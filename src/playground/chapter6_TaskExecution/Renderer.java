package playground.chapter6_TaskExecution;

import com.sun.scenario.effect.ImageData;

import java.util.List;
import java.util.concurrent.*;

public class Renderer {
    private final ExecutorService executor;

    public Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    public void renderPage(CharSequence source) throws Exception {
        List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService =
                imageLoad(info);
        renderText(source);
        renderDownloadImages(info.size(), completionService);
    }

    private void renderDownloadImages(int noOfImages,
                                      CompletionService<ImageData> cs) throws Exception {
        try{

            for (int t = 0; t < noOfImages ; t++) {

                    renderImage(cs.take().get());

            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw launderThrowable(e.getCause());
        }


    }

    private Exception launderThrowable(Throwable cause) {
        return null;
    }

    private void renderImage(ImageData imageData) {
        // render Image
    }

    private void renderText(CharSequence source) {

    }

    private CompletionService<ImageData> imageLoad(List<ImageInfo> info) {
        CompletionService<ImageData> completionService =
                new ExecutorCompletionService<>(executor);
        for (final ImageInfo imageInfo : info) {
            completionService.submit(new Callable<ImageData>() {
                @Override
                public ImageData call() throws Exception {
                    return imageInfo.downloadImage();
                }
            });
        }
        return completionService;
    }

    private List<ImageInfo> scanForImageInfo(CharSequence source) {
        return null;
    }

}
