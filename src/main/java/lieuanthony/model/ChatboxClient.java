package lieuanthony.model;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import lieuanthony.Duplexer;

public class ChatboxClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12410);

        Duplexer duplexer = new Duplexer(socket);

        System.out.print("Enter your name to connect to chatbox: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        duplexer.send(name);
        String response = duplexer.receive();
        System.out.println(response);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    String response = duplexer.receive();
                    if(response.equals("Closing")) {
                        duplexer.close();
                        break;
                    }
                    System.out.println(response);
                }
            }
        });
        thread.start();

        while(thread.isAlive()) {
            String message = scanner.nextLine();
            duplexer.send(message);
            if(message.equals("Quit")) {
                break;
            }
        }

        scanner.close();
    }
}
