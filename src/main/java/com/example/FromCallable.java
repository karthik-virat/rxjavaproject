package com.example;
import io.reactivex.rxjava3.core.Observable;
public class FromCallable {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.fromCallable(() -> {
            System.out.println("Calling Method");
            return getNumber();
        });
        observable.subscribe(System.out::println,
                error -> System.out.println("An Exception Occurred" + error.getLocalizedMessage()));
    }

  
    private static int getNumber() {
        System.out.println("Generating Value");
        return 1 / 0;
    }
}