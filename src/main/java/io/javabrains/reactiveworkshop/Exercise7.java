package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        ReactiveSources.intNumbersFlux()
//                .log()
                .filter(ele -> ele > 5)
                .subscribe(ele -> System.out.println(ele));

        // Print 10 multiplied by each value from intNumbersFlux that's greater than 5
        ReactiveSources.intNumbersFlux()
                .filter(ele -> ele > 5)
                .map(ele -> ele * 10)
                .subscribe(ele -> System.out.println(ele));


        // Print 10 multiplied by each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        ReactiveSources.intNumbersFlux()
                .filter(ele -> ele > 5)
                .take(3)
                .map(ele -> ele * 10)
                .subscribe(ele -> System.out.println(ele));

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        ReactiveSources.intNumbersFlux()
                .filter(ele -> ele > 20)
                .defaultIfEmpty(-1)
                .subscribe(ele -> System.out.println(ele));


        // Switch ints from intNumbersFlux to the right user from userFlux
        ReactiveSources.intNumbersFlux()
                .flatMap(id -> ReactiveSources.userFlux()
                        .filter(user -> user.getId() == id).take(1))
                .subscribe(ele -> System.out.println(ele));

        // Print only distinct numbers from intNumbersFluxWithRepeat
        ReactiveSources.intNumbersFlux()
                .distinct()
                .subscribe(ele -> System.out.println(ele));

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources.intNumbersFlux()
                .distinctUntilChanged()
                .subscribe(ele -> System.out.println(ele));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
