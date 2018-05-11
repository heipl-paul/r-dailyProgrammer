package tutorial.generics;

import java.util.ArrayList;
import java.util.List;

public class BoxDemo {

    public static <U> void addBox(U u, List<Box<U>> boxes) {

        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);

    }

    public static <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box : boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + ++counter + " contains [" + boxContents.toString() + "]"); // yes, arrays start at #1, I know. E pentru prettyness
        }
    }

    public static void start() {
        List<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
        // la compilator nu ii place, <Integer> can be inffered.
        BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        BoxDemo.<Integer>addBox(Integer.valueOf(20), listOfIntegerBoxes);
        BoxDemo.<Integer>addBox(Integer.valueOf(30), listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        printList(intList);
    }

    public static void printList(List<? extends Number> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

}
