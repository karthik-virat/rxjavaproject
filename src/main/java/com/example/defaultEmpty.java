package com.example;
import io.reactivex.rxjava3.core.Observable;
public class defaultEmpty {
    public static void main(String[] args) {
        useDefaultIfEmpty();
        useSwitchIfEmpty();
    }

    /**
     * Used defaultIfEmpty() operator so the observer will emit at least a default value
     * if the emission gets empty
     */
    private static void useDefaultIfEmpty() {
        Observable.just(1,2,3,4,5)
                .filter(item -> item > 10)
                .defaultIfEmpty(100)
                .subscribe(System.out::println);
    }

    /**
     * This will switch to some alternative Observable Source
     * if the emission gets empty
     */
    private static void useSwitchIfEmpty() {
        Observable.just(1,2,3,4,5)
                .filter(item -> item > 10)
                .switchIfEmpty(Observable.just(6,7,8,9,10))
                .subscribe(System.out::println);
    }
}
