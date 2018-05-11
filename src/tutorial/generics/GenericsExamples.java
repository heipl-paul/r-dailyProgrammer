package tutorial.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsExamples {

    public static void betterForCasting() {
        List<String> list = new ArrayList<>();
        list.add("a string");
        list.add("Another String");

        for (String s : list)
            System.out.println(s);
    }

    public static void boxesTest() {

        List<Box<String>> boxes = new ArrayList<>();
        Box<String> box = new Box<>();
        Box<String> box2 = new Box<>();
        box.set("a string");
        box2.set("Another String");

        boxes.add(box);
        boxes.add(box2);

        for (Box b : boxes)
            System.out.println(b.get());

        box.inspect(123.0);

    }

    public static void pairTest() {

        List<Pair<Integer, String>> list = new ArrayList<>();
        list.add(new OrderedPair<>(1, "First String"));
        list.add(new OrderedPair<>(2, "Second String"));
        list.add(new OrderedPair<>(3, "Third String"));

        for (Pair<Integer, String> p : list)
            System.out.println(p.getKey() +  " " + p.getValue());

    }

    // <? super Class> sets a lower bounds. Extends sets an upper bound
    public static void sumOfNumbers(List<? extends Number> numbers) {

        double d = 0.0;
        for (Number n : numbers) {
            d += n.doubleValue();
        }
        System.out.println(d);

    }

    // Generic Types <K, V> must appear before the return type!
    @SuppressWarnings("Unchecked")
    private static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

    @SuppressWarnings("unused")
    public static <K, V> boolean compareTest() {
        Pair<Integer, String> p1 = new OrderedPair<>(1, "Test");
        Pair<Integer, String> p2 = new OrderedPair<>(1, "Test");
        return GenericsExamples.compare(p1, p2);
    }

    public static void extendsTest() {
        Box<Integer> integerBox = new Box<>();
        integerBox.set(5);
        integerBox.inspect(integerBox.get());
        integerBox.set(5);
        integerBox.inspect(integerBox.get());
        Box<Double> doubleBox = new Box<>();
        doubleBox.set(5d); // Even though it is seen as Integer in inspect
        doubleBox.inspect(integerBox.get()); // Still won't allow new Integer(x);
        doubleBox.set(5.1);
        doubleBox.inspect(doubleBox.get());
//        integerBox.inspect("some text");


    }

    public static void classTest() {
        Double integer = 5d;
        Double realDouble = 5.1;
        System.out.println(integer + " " + "Probably an integer?\t" + integer.getClass().getName());
        System.out.println(realDouble + " " + "Real Double?\t\t\t" + realDouble.getClass().getName());
        integer += 0.1;
        System.out.println(integer + " " + "Still an integer?\t\t" + integer.getClass().getName());
    }

    public static void printListTest() {
        List<Integer> li = Arrays.asList(1,2,3);
        List<String> ls = Arrays.asList("one", "two", "three");
        printList(li);
        printList(ls);
    }

    private static void printList(List<?> list) {
        for (Object elem : list)
            System.out.println(elem + " ");
    }

    @SuppressWarnings("unused")
    public static <T> void wildCardCaptureFixed (List<T> l) {
        l.set(0, l.get(0));
    }

/*
//  Does not work
    @SuppressWarnings("unused")
    private static void wildCardCaptureError (List<?> i) {
        i.set(0, i.get(0));
    }
*/
/*
    @SuppressWarnings("unused")
    private static void wildCardErrorBad (List<? extends Number> l1, List<? extends Number> l2) {
        Number temp =  l1.get(0);
        l1.set(0, l2.get(0));   // Unsafe operation. Could put a Double in an Integer list.
        l2.set(0, temp);
    }
        // Method as is can't be fixed, it is fundamentally wrong.
        // What would work: ` ... static <T> void (List<T>, List<T>) { ... }
        // But this changes the whole intent of the method.
*/

}