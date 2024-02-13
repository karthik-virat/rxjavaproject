package com.example;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ps_re {
    public static void main(String[] args) {
        // Creating an Observable
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        // Creating an Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                // Called when the Observer subscribes to the Observable
                System.out.println("Subscribed");
            }

            @Override
            public void onNext(Integer integer) {
                // Called when the Observable emits an item
                System.out.println("Received: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                // Called when an error occurs
                System.err.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                // Called when the Observable completes emitting items
                System.out.println("Completed");
            }
        };

        // Connecting the Observable to the Observer
        observable.subscribe(observer);
    }
}
