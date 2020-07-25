package playground.chapter7_CancellationAndShutdown;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class IndexingService {
    private static final File POISON = new File("");
    private static final int CAPACITY = 10;
    private final CrawlerThread producer = new CrawlerThread();
    private final IndexerThread consumer = new IndexerThread();

    private final BlockingQueue<File> queue = new LinkedBlockingQueue<>(CAPACITY);
    public void start(){
        producer.start();
        consumer.start();
    }
    public void stop(){
        producer.interrupt();
    }
    public void awaitTermination() throws InterruptedException{
        consumer.join();
    }

    // producer thread
    // On interruption it puts a poison pill on the queue
    private class CrawlerThread extends Thread{
        @Override
        public void run() {
            try{
                File root = new File("/");
                crawl(root);
            }catch(InterruptedException consume){/* exit crawl */}
            while (true){
                try{

                    queue.put(POISON);
                    break;
                }catch(InterruptedException e2){/* retry */}
            }
        }
        private void crawl(File root) throws InterruptedException{}
    }

    // Consumer thread
    private class IndexerThread extends Thread{
        @Override
        public void run() {
            try{
                while(true){
                    File file = queue.take();
                    if(file == POISON)
                        break;
                    else
                        indexFile(file);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void indexFile(File file) {
            // index files
        }
    }
}
