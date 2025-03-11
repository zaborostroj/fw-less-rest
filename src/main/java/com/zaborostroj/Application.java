package com.zaborostroj;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Application {

    public static void main(String[] args) throws IOException {
        int serverPort = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        server.createContext("/api/hello", (exchange -> {
            String response = "Hello World!";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.flush();
            exchange.close();
        }));
        server.setExecutor(null);
        server.start();
    }
}
