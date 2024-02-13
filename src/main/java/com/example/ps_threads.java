package com.example;

import java.util.ArrayList;
import java.util.List;

class Publisher implements Runnable {
    private List<Subscriber> subscribers;
    private boolean running;

    public Publisher() {
        subscribers = new ArrayList<>();
        running = true;
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receive(message);
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        int count = 0;
        while (running) {
            notifySubscribers("Message " + count++);
            try {
                Thread.sleep(1000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Subscriber {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void receive(String message) {
        System.out.println(name + " received: " + message);
    }
}

public class ps_threads{
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Subscriber subscriber1 = new Subscriber("Subscriber 1");
        Subscriber subscriber2 = new Subscriber("Subscriber 2");

        publisher.addSubscriber(subscriber1);
        publisher.addSubscriber(subscriber2);

        Thread publisherThread = new Thread(publisher);
        publisherThread.start();

        // Simulate running for some time
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the publisher
        publisher.stop();

        // Wait for publisher thread to finish
        try {
            publisherThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
