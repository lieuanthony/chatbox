package lieuanthony.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lieuanthony.Duplexer;

public class ChatboxServer {
    public static List<ChatboxProxy> proxies = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try(ServerSocket server = new ServerSocket(12410)) {

            while(true) {
                Socket client = server.accept();
                Duplexer duplexer = new Duplexer(client);
                String name = duplexer.receive();
                duplexer.send("Connected");
                for(ChatboxProxy proxy : ChatboxServer.proxies ) {
                    proxy.send(name + ": " + "Connected");
                }
                ChatboxProxy proxy = new ChatboxProxy(client, name);
                proxies.add(proxy);
                Thread thread = new Thread(proxy);
                thread.start();
            }
        }
    }
}