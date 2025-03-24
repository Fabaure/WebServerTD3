import java.io.*;
import java.net.Socket;


public class HttpRequest {
    private String method;
    private String Url;

    private void readClientRequest(Socket socket) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = input.readLine();
        if (response != null){
            String[] parts = response.split(" ");
            method = parts[0];
            Url = parts[1];
        }
    }

    public HttpRequest(Socket socket) throws IOException {
        readClientRequest(socket);
    }
    public String getMethod() {
        return method;
    }
    public String getUrl() {
        return Url;
    }
}