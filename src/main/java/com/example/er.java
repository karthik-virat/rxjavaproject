package com.example;
import io.reactivex.rxjava3.core.Observable;
public class er {
    public static void main(String[] args) {
        throwException();
        throwExceptionUsingCallable();
    }

    
    private static void throwException() {
        Observable<Throwable> observable = Observable.error(new Exception("An Exception"));
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }

  
    private static void throwExceptionUsingCallable() {
        Observable<Throwable> observable = Observable.error(() -> {
   
            System.out.println("New Exception Created");
            return new Exception("An Exception");
        });
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }
}