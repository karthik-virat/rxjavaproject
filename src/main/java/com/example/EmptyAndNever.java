package com.example;

import io.reactivex.rxjava3.core.Observable;

import static java.lang.Thread.sleep;


public class EmptyAndNever {
    public static void main(String[] args) {
        createObservableUsingEmpty();
        createObservableUsingNever();
    }

   
    private static void createObservableUsingEmpty() {
        Observable<Object> observable = Observable.empty();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }


    private static void createObservableUsingNever() {
        Observable<Object> observable = Observable.never();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
        // Pause the main thread for the hope that it will print something
        pause(3000);
    }

   
    private static void pause(int duration) {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}