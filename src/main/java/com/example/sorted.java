package com.example;
import io.reactivex.rxjava3.core.Observable;
import java.util.Comparator;

public class sorted {

    public static void main(String[] args) {
        useSorted();
        useSortedWithOwnComparator();
        useSortedOnNonComparator();
    }

    /**
     * This used sorted operator to sort the operator
     */
    private static void useSorted() {
        Observable.just(3, 5, 2, 4, 1)
                .sorted()
                .subscribe(System.out::println);
    }

    /**
     * This used sorted operator along with Comparators reverse function
     * to sort and reverse the emission
     */
    private static void useSortedWithOwnComparator() {
        Observable.just(3, 5, 2, 4, 1)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);
    }

    /**
     * This used sorted operator along with Integer's compare function to
     * sort the emission based on their length
     */
    private static void useSortedOnNonComparator() {
        Observable.just("foo", "john", "bar")
                .sorted((first, second) -> Integer.compare(first.length(), second.length()))
                .subscribe(System.out::println);
    }

}