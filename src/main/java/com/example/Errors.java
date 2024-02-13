package com.example;
import io.reactivex.rxjava3.core.Observable;
import java.io.IOException;
public class Errors {

    public static void main(String[] args) {
        exDoOnError();
        exOnErrorResumeNext();
        exOnErrorReturn();
        exOnErrorReturnItem();
    }

    /**
     * The error goes to the doOnError lambda on the chain first, so we can handle it
     */
    private static void exDoOnError() {
        Observable.error(new Exception("This is an example error"))
                .doOnError(error -> System.out.println("Error: " + error.getMessage()))
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    /**
     * Whenever an error is found on the chain, it goes to the onErrorResumeNext
     * As this takes another Observable, the subscriber switch to that Observable
     * to skip the error
     */
    private static void exOnErrorResumeNext() {
        
        Observable.error(new Exception("This is an example error"))
        .onErrorResumeNext(error -> Observable.just(1, 2, 3, 4, 5))
        .subscribe(
              System.out::println,
              error -> System.out.println("Subscribed Error: " + error.getMessage()),
              () -> System.out.println("Completed"));
}

    

    /**
     * We can return specific values based on the error type
     * As when we get the error it goes to the onErrorReturn lambda
     */
    private static void exOnErrorReturn() {
        Observable.error(new Exception("This is an example error"))
                .onErrorReturn(error -> {
                    if (error instanceof IOException) return 0;
                    else throw new Exception("This is an exception");
                })
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    /**
     * We can pass an alternative for the subscriber below the chain
     * Whenever error encounters it gives that specific alternative
     */
    private static void exOnErrorReturnItem() {
        Observable.error(new IOException("This is an example error"))
                .onErrorReturnItem(1)
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

}

