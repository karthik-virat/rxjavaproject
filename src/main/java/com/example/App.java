package com.example;

import io.reactivex.rxjava3.core.Observable;

public class App{
    public static void main(String[] args) {
        Observable.just("Hello, RxJava!")
            .subscribe(System.out::println);
    }
}
