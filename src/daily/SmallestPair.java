package daily;

/**
 * Daily Programmer
 * [2018-03-12] #354 [Easy]
 */
public class SmallestPair {

    /**
     * Finds a pair of numbers that multiplied produce the input number, but added produce
     * the smallest possible sum
     * @param number - Long
     */
    public static void find(Long number) {

        // Compiler complains about primitive double to Long. Looks convoluted, but works.
        for (Long pair = (long) Math.sqrt(number); pair > 0L; pair--) {
            if (number % pair == 0) {
                //print(pair, (number / pair));
                return;
            }
        }

    }

    private static void print(Long pair1, Long pair2) {
        System.out.println((pair1*pair2) + " = " + pair1 + " * " + pair2
                + " => " + pair1 + " + " + pair2 + " = " + (pair1 + pair2));
    }

}
