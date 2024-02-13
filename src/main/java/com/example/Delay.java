package com.example;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;



public class Delay {

    public static void main(String[] args) {
        delay();
        delayError();
    }

    /**
     * Used 'delay' operator to add a delay before the Observable start emission
     * Note: 'delay' doesn't delay each emission, instead it delays the start of the emission
     */
    private static void delay() {
        Observable.just(1, 2, 3, 4, 5)
                .delay(3000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        pause(5000);
    }

    /**
     * 'delay' operator doesn't add any delay before emitting error
     * This means the error is immediately emitted to it's subscribers by default
     * To delay the emission of error we need to pass delayError parameter as true
     */
    private static void delayError() {
        Observable.error(new Exception("Error"))
                .delay(3, TimeUnit.SECONDS, true)
                .subscribe(System.out::println,
                        error -> System.out.println(error.getLocalizedMessage()),
                        () -> System.out.println("Completed"));
        pause(5000);
    }

    /**
     * This method sleep the main thread for specified duration
     *
     * @param duration Sleep Duration in Milliseconds
     */
    private static void pause(int duration) {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}