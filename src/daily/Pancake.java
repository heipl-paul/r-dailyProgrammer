package daily;

import java.util.ArrayList;
import java.util.Collections;

public class Pancake {

    private ArrayList<Integer> stack;
    private int flips = 0;
    private int bottomPosition;
    private int bottomValue;

    public Pancake(ArrayList<Integer> stack) {
        this.stack = stack;
        this.bottomPosition = stack.size() - 1;
        this.bottomValue = stack.size();
    }

    /**
     * <p>Test documentation is test
     * {@Code test} and more tests<br>
     * @param stack
     */ /* Test */
    public Pancake(int numberOf) {
        this.stack = new ArrayList<>(numberOf);
        for (int i = 0; i < numberOf; i++)
            stack.add(i + 1);
        Collections.shuffle(stack);
        this.bottomPosition = stack.size() - 1;
        this.bottomValue = stack.size();
    }

    public int sort(boolean verbose) {

        while (bottomPosition > 0) {    // it makes no sense to ever flip just the top pancake

            if (isBottomTop()) {
                flip(bottomPosition, verbose);
                raiseBottom();
            } else
            if (isNextSorted())
                raiseBottom();
            else {
                findAndFlip(verbose);
            }

        }
        return flips;

    }

    private void findAndFlip(boolean verbose) {
        for (int position = bottomPosition - 1; position >= 0; position--) {
            if (stack.get(position) == bottomValue) {
                flip(position, verbose);        // we move the largest remaining pancake at the top
                flip(bottomPosition, verbose);  // we flip from the previous largest pancake up
                raiseBottom();
                break;
            }
        }
    }

    private boolean isBottomTop() {
        if (stack.get(0) == bottomValue)
            return true;
        return false;
    }

    private boolean isNextSorted() {
        if (stack.get(bottomPosition) == bottomValue)
            return true;
        return false;
    }

    private void raiseBottom() {
        bottomPosition--;
        bottomValue--;
    }

    /**
     * Places the spatule under the desired position, flipping all above pancakes.
     */
    private void flip(int position, boolean verbose) {
        for (int i = 0; i <= position / 2; i++) {
            int aux = stack.get(position - i);
            stack.set(position - i, stack.get(i));
            stack.set(i, aux);
        }
        flips++;
        if (verbose) print();
    }

    public ArrayList<Integer> getStack() {
        return stack;
    }

    public void print() {
        System.out.println(stack.toString());
        System.out.println("Flips: " + flips);
    }

}
