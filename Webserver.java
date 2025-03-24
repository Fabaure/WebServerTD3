import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Webserver {
    private int port;
    public Webserver(int port) {
        this.port = port;
    }
    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serveur demarre sur le port " + port);
            while (true) {
                Socket Socket = serverSocket.accept();
                System.out.println("Connexion acceptee");
                new RequestProcessor(Socket);
            }
        } catch (IOException e) {
            e.printStackTrace();}
    }
}
