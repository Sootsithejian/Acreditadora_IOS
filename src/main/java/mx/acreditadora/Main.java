
package mx.acreditadora;

import mx.acreditadora.rest.RestApplication;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.gson.JsonGsonFeature;

import java.net.URI;

public class Main {

    public static void main(String[] args) {

        int port = Integer.parseInt(
            System.getenv().getOrDefault("PORT", "8080")
        );

        ResourceConfig config = ResourceConfig.forApplication(
            new RestApplication()
        );

        config.packages("mx.acreditadora.rest");

        // Registrar soporte JSON con Gson
        config.register(JsonGsonFeature.class);

        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
            URI.create("http://0.0.0.0:" + port + "/"),
            config
        );

        System.out.println("API ACREDITADORA INICIADA");
        System.out.println("Puerto: " + port);
    }
}
