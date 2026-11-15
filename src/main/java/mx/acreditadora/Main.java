package mx.acreditadora;

import mx.acreditadora.rest.RestApplication;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {

    public static void main(String[] args) {

        ResourceConfig config = ResourceConfig.forApplication(
            new RestApplication()
        );

        config.packages("mx.acreditadora.rest");

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
            URI.create("http://0.0.0.0:8080/"),
            config
        );

        System.out.println("API ACREDITADORA INICIADA");
        System.out.println("http://localhost:8080/api/health");
    }
}