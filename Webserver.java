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
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connexion acceptee");
                readRequest(clientSocket);
                sendResponse(clientSocket);
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();}
    }

    private void readRequest(Socket clientSocket) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String response = "";
        System.out.println("=== Requete du client ===");
        while ((response = input.readLine()).isEmpty() == false)
            System.out.println(response);
        }

    private void sendResponse(Socket clientSocket) throws IOException {
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        output.write("Bonjour, ceci est une reponse du serveur");
        output.flush();
    }
}
