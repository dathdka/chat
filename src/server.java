import java.io.IOException;

import java.net.*;
public class server {
    public ServerSocket ss;


    public server( ServerSocket ss) {
        this.ss = ss;
    }
    public void startServer(){
        try {
            while (!ss.isClosed()) {
                Socket socket =  ss.accept();
                System.out.println("+1 tham gia doan chat");
                ClientHandler ch = new ClientHandler(socket);
                Thread thread =  new Thread(ch);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    public void closeServerSocket(){
        try {
            if (ss !=null)
                ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1234)) {
            server sv = new server(ss);
            sv.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
