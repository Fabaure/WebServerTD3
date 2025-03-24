import java.io.IOException;
import java.net.Socket;

public class HttpContext {
    private HttpRequest request;
    private HttpResponse response;
    private Socket socket;

    public HttpContext(Socket socket) throws IOException{
        this.socket = socket;
        this.request = new HttpRequest(socket);
        this.response = new HttpResponse(socket);
    }

    public HttpRequest getRequest() {
        return request;
    }

    public HttpResponse getResponse() {
        return response;
    }

    public void close() {
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
    }
}
}

