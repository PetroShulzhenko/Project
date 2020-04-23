package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CompletableFuture;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dbService.DBException;
import dbService.DBService;
import dbService.InvalidSymbolsException;
import model.Login;
import main.SetupObjects;

@Path(ResetPasswordService.url)
public class ResetPasswordService {
    public static final String url = "/reset_password";

    private final DBService dbService = SetupObjects.getDbService();
    private final String fromEmail = SetupObjects.getFromEmail();
    private final String emailPassword = SetupObjects.getEmailPassword();
    private final ExecutorService executorService = SetupObjects.getExecutorService();

    private void send(String toEmail) {
        // relay.jangosmtp.net
        String host = "smtp.gmail.com";

        // SSL protocol is used
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(fromEmail, emailPassword);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(fromEmail));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            // Set Subject: header field
            message.setSubject("Reset password");

            // Now set the actual message
            message.setText("Testing");

            // Send message
            Transport.send(message);

            System.err.println("Reset message sent to " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void sendResetEmail(@FormParam("toEmail") String toEmail) throws Throwable {
        try {
            if (dbService.checkUser(toEmail)) {       // checking whether account exists
                CompletableFuture.supplyAsync(() -> {
                    send(toEmail);
                    return null;
                }, executorService);
            }
        } catch (DBException e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }
    }

    @PUT
    @Path("/reset")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public Response resetPassword(@FormParam("login") String login, @FormParam("password") String password) {
        try {
            dbService.updatePassword(new Login(login, password));
        } catch (DBException e) {
            e.printStackTrace();
            return Response.status(Response.Status.FORBIDDEN)
                            .entity(false).build();
        }

        return Response.status(Response.Status.OK)
                        .entity(true).build();
    }
}
