package playground.chapter6_TaskExecution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Starting a new thread for each task is more responsive
 * - But could crash the server with too many active client connections
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true){
            final Socket socket = serverSocket.accept();
            new Thread(){
                public void run(){
                    handleRequest(socket);
                }
            }.start();
        }
    }

    private static void handleRequest(Socket socket) {
        // do Something to handle Request
    }
}
