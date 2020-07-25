package playground.chapter6_TaskExecution;

import org.omg.CORBA.Request;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class LifeCycleWebServer {
    private final ExecutorService exec = Executors.newCachedThreadPool();

    public void start() throws IOException {
        // We should set socket timeout otherwise accept() might
        //never let us return from  start()
        ServerSocket serverSocket = new ServerSocket(80);
        while(!exec.isShutdown()){
            try{
                final Socket conn = serverSocket.accept();
                exec.execute(() -> handleRequest(conn));

            }catch (RejectedExecutionException e){
                System.out.println("task submission rejected" + e);
            }
        }

    }

    private void handleRequest(Socket connection) {
        // Handle request as below
        /*Request req = readRequest(connection);
        if(isShutdownRequest(req))
            stop();
        else
            dispatch(req);*/
    }

    private void stop() {
        exec.shutdown();
    }
}
