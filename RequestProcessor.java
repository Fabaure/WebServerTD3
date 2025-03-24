import java.io.*;
import java.net.Socket;


public class RequestProcessor {
    private Socket socket;

    public RequestProcessor(Socket socket) {
        this.socket = socket;
        process();
    }
    private void process(){
        try {
            HttpContext context = new HttpContext(socket);
            HttpRequest request = new HttpRequest(socket);
            HttpResponse response = new HttpResponse(socket);
            
            System.out.println("Requete reçue: " + request.getMethod() + " " + request.getUrl());

            if ("/".equals(request.getUrl())) {
                response.sendOk("Salut, bienvenue sur mon serveur");
                response.sendContent("text/html", "<h1>Hello World!</h1>");
            } else {
                response.sendNotFound("Pas d'URL correspondante");
            }
            context.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}