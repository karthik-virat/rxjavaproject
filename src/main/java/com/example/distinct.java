package com.example;
import io.reactivex.rxjava3.core.Observable;
public class distinct {
    public static void main(String[] args) {
        distinctOperator();
        distinctWithKeySelector();
        distinctUntilChangedOperator();
        distinctUntilChangedWithKeySelector();
    }

    /**
     * Used the distinct() to get the unique emission
     */
    private static void distinctOperator() {
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinct()
                .subscribe(System.out::println);
    }

    /**
     * Used the distinct based on the item's property to distinguish emission
     */
    private static void distinctWithKeySelector() {
        Observable.just("foo", "fool", "super", "foss", "foil")
                .distinct(String::length)
                .subscribe(System.out::println);
    }

    /**
     * Used distinctUntilChanged() to avoid consecutive duplicate items one after another
     */
    private static void distinctUntilChangedOperator() {
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinctUntilChanged()
                .subscribe(System.out::println);
    }

    /**
     * Used distinctUntilChangedOperator() based on the item's property to distinguish the consecutive duplicate items
     */
    private static void distinctUntilChangedWithKeySelector() {
        Observable.just("foo", "fool", "super", "foss", "foil")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);
    }
}
