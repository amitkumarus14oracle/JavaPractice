package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureImpl {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();
        //boolean result = future.complete("future completed");
        CompletableFuture<String> fut = CompletableFuture.supplyAsync(()->{
            return "amit";
        }).thenApply(s -> {
            System.out.println("Welcome :"+ s);
            return "Welcome :"+ s;
        }).thenApply(o -> {
            System.out.println(o + " did you come");
            return o + " did you come";
        });
        future.complete("future completed");
        try {
            System.out.println("its there "+fut.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
