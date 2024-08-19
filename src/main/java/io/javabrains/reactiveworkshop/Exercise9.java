package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        ReactiveSources.intNumbersFlux()
                .count()
                .subscribe(ele -> System.out.println(ele));

        // Collect all items of intNumbersFlux into a single list and print it
        ReactiveSources.intNumbersFlux()
                .collectList()
                .subscribe(ele -> System.out.println(ele));

        // Transform to a sequence of sums of adjacent two numbers
        ReactiveSources.intNumbersFlux()
                .buffer(2)
                .map(list -> list.get(0) + list.get(1))
                .subscribe(ele -> System.out.println(ele));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
