import java.io.*;
import java.net.Socket;


public class HttpResponse {
    private OutputStream output;
    HttpResponse(Socket socket) throws IOException {
        this.output = socket.getOutputStream();
    }


    public void sendNotFound(String message) throws IOException {
        String response = "HTTP/1.0 404 Not Found\r\n" + message;
        output.write(response.getBytes());
        output.flush();
    }

    public void sendOk(String message) throws IOException {
        String response = "HTTP/1.0 200 OK\r\n" + message;
        output.write(response.getBytes());
        output.flush();
    }

    public void sendContent(String contentType, String content) throws IOException {
        String response = "Content-Type: " + contentType + "\r\n\r\n" + content;
        output.write(response.getBytes());
        output.flush();
    }
}