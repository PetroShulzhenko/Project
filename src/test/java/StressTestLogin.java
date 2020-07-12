import main.*;
import org.glassfish.grizzly.http.server.HttpServer;

public class StressTestLogin {
    private HttpServer server;

    public void setUp() {
        server = Main.startServer();
    }

}
