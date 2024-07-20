package lieuanthony;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Duplexer {
    private Socket socket;
    private Scanner scanner;
    private PrintWriter writer;
    
    public Duplexer(Socket socket) throws IOException {
        this.socket = socket;
        this.scanner = new Scanner(socket.getInputStream());
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    public void send(String message) {
        System.out.println(">> " + message);
        writer.println(message);
        writer.flush();
    }

    public String receive() {
        String message = scanner.nextLine();
        System.out.println("<< " + message);
        return message;
    }

    public void close() {
        try {
            socket.close();
            scanner.close();
            writer.close();
        } catch (IOException e) {}
    }
}
