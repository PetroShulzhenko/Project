package main;

import dbService.DBException;
import org.glassfish.grizzly.http.server.*;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {
    public static final String uri = "http://localhost:8080/gym/";

    public static HttpServer startServer() {
        ResourceConfig resourceConfig = bootstrapServer();

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(uri), resourceConfig, false);
    }

    private static ResourceConfig bootstrapServer() {
        SetupObjects.init("pswresetforboreyko@gmail.com", "1234567890wsxrfvyhnik,", 10);

        return new ResourceConfig().packages("rest", "JWTHelper", "model");
    }

    public static void main(String[] args) {
        final HttpServer server = startServer();

        server.getServerConfiguration().addHttpHandler(new CLStaticHttpHandler(Main.class.getClassLoader(), "/static/"), "/");

        try {
            server.start();
            System.err.println("Press any key to shut down the server");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            SetupObjects.getExecutorService().shutdownNow();
            server.shutdownNow();
        }
    }
}
