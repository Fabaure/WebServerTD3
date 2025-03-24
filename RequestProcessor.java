import java.io.*;
import java.net.Socket;


public class RequestProcessor implements Runnable {
    private Socket Socket;

    public RequestProcessor(Socket Socket) {
        this.Socket = Socket;
    }
    private void process(){
        try {
            HttpContext context = new HttpContext(Socket);
            HttpRequest request = new HttpRequest(Socket);
            HttpResponse response = new HttpResponse(Socket);
            
            System.out.println("Requete reçue: " + request.getMethod() + " " + request.getUrl());

            if ("GET".equals(request.getMethod())) {
                if ("/".equals(request.getUrl())) {
                    response.sendOk("<h1>Salut</h1>");
                } else {
                    response.sendNotFound("Pas d'URL correspondante");
                }
            } else {
                response.sendNotFound("Pas de methode correspondante");
            }

            context.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        process();
    }
}