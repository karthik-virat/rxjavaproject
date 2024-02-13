package com.example;
import io.reactivex.rxjava3.core.Observable;
public class Defer {
    private static int start = 5, count = 2;

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.defer(() -> {
            System.out.println("New Observable is created with start = " + start + " and count = " + count);
            return Observable.range(start, count);
        });
        observable.subscribe(item -> System.out.println("Observer 1: " + item));
        count = 3;
        observable.subscribe(item -> System.out.println("Observer 2: " + item));
    }
}