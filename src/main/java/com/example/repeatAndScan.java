package com.example;
import io.reactivex.rxjava3.core.Observable;
public class repeatAndScan {
    public static void main(String[] args) {
        useRepeat();
        useScan();
        useScanWithInitialValue();
    }

    /**
     * This used repeat operator to specify how many times emission witll repeat
     */
    private static void useRepeat() {
        Observable.just(1, 2, 3, 4, 5)
                .repeat(3)
                .subscribe(System.out::println);
    }

    /**
     * This uses scan operator to print the sum of the previously emitted item and current one that is going to emit
     */
    private static void useScan() {
        Observable.just(1, 2, 3, 4, 5)
                .scan((accumulator, next) -> accumulator + next)
                .subscribe(System.out::println);
    }

    /**
     * This uses scan operator print the sum of the previously emitted item and current one that is going to emit,
     * but this also takes the initial emission into consideration by specifying an initial value
     */
    private static void useScanWithInitialValue() {
        Observable.just(1, 2, 3, 4, 5)
                .scan(10, (accumulator, next) -> accumulator + next)
                .subscribe(System.out::println);
    }

}
