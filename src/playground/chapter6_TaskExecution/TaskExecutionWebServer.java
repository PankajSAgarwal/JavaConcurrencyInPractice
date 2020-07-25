package playground.chapter6_TaskExecution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * WebServer using Executor
 */
public class TaskExecutionWebServer {
    private static final int NTHREADS = 100;
    private static final Executor exec =
            Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true){
            final Socket socket = serverSocket.accept();
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    handleRequest(socket);
                }
            });
        }
    }

    private static void handleRequest(Socket socket) {
        // do Something
    }
}
