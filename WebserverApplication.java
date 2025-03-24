public class WebserverApplication {
    public static void main(String[] args) {
        Webserver server = new Webserver(80);
        server.run();
    }
}

