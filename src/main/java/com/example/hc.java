package com.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;


import static java.lang.Thread.sleep;
public class hc{
    public static void main(String[] args) {
        createColdObservable();
        createHotAndConnectableObservable();
    }
    private static void createColdObservable() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        observable.subscribe(item -> System.out.println("Observer 1: " + item));

        pause(3000);

        observable.subscribe(item -> System.out.println("Observer 2: " + item));
    }

   
    private static void createHotAndConnectableObservable() {
        ConnectableObservable<Integer> observable = Observable.just(1, 2, 3, 4, 5).publish();

        observable.subscribe(item -> System.out.println("Observer 1: " + item));
        observable.connect();
        observable.subscribe(item -> System.out.println("Observer 2: " + item));
        
    } 


    private static void pause(int duration) {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}