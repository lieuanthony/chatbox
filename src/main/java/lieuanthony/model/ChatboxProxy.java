package lieuanthony.model;

import java.io.IOException;
import java.net.Socket;

import lieuanthony.Duplexer;

public class ChatboxProxy extends Duplexer implements Runnable {
    private final String name;

    public ChatboxProxy(Socket socket, String name) throws IOException {
        super(socket);
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            String message = this.receive();

            if(message.equals("Quit")) {
                ChatboxServer.proxies.remove(this);
                for(ChatboxProxy proxy : ChatboxServer.proxies ) {
                    proxy.send(name + ": " + "Quit");
                }
                this.send("Closing");
                this.close();
                break;
            }

            for(ChatboxProxy proxy : ChatboxServer.proxies ) {
                if(proxy != this) {
                    proxy.send(name + ": " + message);
                }
            }
        }
    }
}