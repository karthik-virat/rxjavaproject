package com.example;
import io.reactivex.rxjava3.core.Observable;
public class contain {

    public static void main(String[] args) {
        containsWithPremitive();
        containsWithNonPremitive();
    }

    /**
     * contains operator checks if the number exist in the Observable emission
     * As soon as it gets the item it emits true or false otherwise
     */
    private static void containsWithPremitive() {
        Observable.just(1, 2, 3, 4, 5)
                .contains(3)
                .subscribe(System.out::println);
    }

    /**
     * contains operator checks if the specific object exist in the Observable emission
     * based on the Object's hashcode
     * As soon as it gets the item it emits true or false otherwise
     */
    private static void containsWithNonPremitive() {
        User user = new User("mroydroid");
        Observable.just(user)
                .contains(user)
                .subscribe(System.out::println);
    }

    /**
     * a static class for demonstration purpose
     */
    static class User {
        String name;

        User(String name) {
            this.name = name;
        }
    }

}