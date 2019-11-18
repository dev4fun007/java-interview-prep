package bytes.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class Stream {

    private List<Integer> list = new ArrayList<>();

    private void populateList() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
    }


    public void start() {
        populateList();
        stream();
    }

    private void stream() {
        //Count objects in stream - returns a number
        System.out.printf("Count: %d", list.stream().count());
        System.out.println();

        //Check for anyMatch - will return true or false
        System.out.printf("Any Even Number in List: %s", list.stream().anyMatch(n -> n % 2 == 0));
        System.out.println();

        //Filter and print - for each is terminal operation
        list.stream().filter(n -> n % 5 == 0)
                    .forEach(System.out::println);
        System.out.println();

        //Convert to IntStream and then get the max as Optional
        OptionalInt max = list.stream().mapToInt(Integer::intValue)
                .max();
        if(max.isPresent())
            System.out.printf("Max int value: %d", max.getAsInt());
        System.out.println();
        
    }


}
