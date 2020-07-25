package playground.chapter6_TaskExecution;

import com.sun.scenario.effect.ImageData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureRenderer {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void renderPage(CharSequence source) throws Exception {
        Future<List<ImageData>> images = imageLoad(source);
        renderText(source);
        renderDownloadImages(images);
    }

    private void renderText(CharSequence source) {
        // do something to render text
    }

    private void renderDownloadImages(Future<List<ImageData>> images) throws Exception {
        // do something to render downlaod images
        try{
            for(ImageData data:images.get())
                renderImage(data);
        }catch (InterruptedException e){
            // Re-assert the thread's interrupted status
            Thread.currentThread().interrupt();
            // We don't need the result,so cancel the task too
            images.cancel(true);
        }catch (ExecutionException e){
            throw launderThrowable(e.getCause());
        }
    }

    private Exception launderThrowable(Throwable cause) {
        return null;
    }

    private void renderImage(ImageData data) {
        // do something to render ImageData
    }

    private Future<List<ImageData>> imageLoad(CharSequence source){
        final List<ImageInfo> infos = scanForImageInfo(source);
        Callable<List<ImageData>> task = new Callable<List<ImageData>>() {
            @Override
            public List<ImageData> call() throws Exception {
                List<ImageData> result = new ArrayList<>();
                for(ImageInfo info:infos)
                    result.add(info.downloadImage());
                return result;
            }
        };
        return executor.submit(task);
    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        // do something to scna Image Info and return List of ImageInfo
        return null;
    }


}
