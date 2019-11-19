package bytes.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SplitIteratorClass {

    private List<Integer> list = new ArrayList<>();

    public void start() {
        populateList();
        iterate();
    }

    private void populateList() {
        list = Arrays.asList(1, 10, -5, 12);
    }

    private void iterate() {
        Spliterator<Integer> spliterator = list.spliterator();
        Spliterator<Integer> spliterator1 = spliterator.trySplit();

        System.out.println("Now first split iterator");
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("Now second split iterator");
        while (spliterator1.tryAdvance(System.out::println));

    }

}
