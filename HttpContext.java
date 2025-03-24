import java.io.IOException;
import java.net.Socket;

public class HttpContext {
    private Socket socket;

    public HttpContext(Socket socket) throws IOException{
        this.socket = socket;
    }

    public HttpRequest getRequest() throws IOException {
        return new HttpRequest(socket);
    }

    public HttpResponse getResponse() throws IOException  {
        return new HttpResponse(socket);
    }

    public void close() {
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
    }
}
}

