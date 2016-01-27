import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by TheFallen on 1/27/16.
 */
// parallelSort() in java 8 / Lambda Expressions
public class QuicksortTest {
    public static void main(String[] args) {

        final int SIZE = 30;

        final List<Integer> myList = new ArrayList<>(SIZE);

        for (int i=0; i<SIZE; i++){
            int value = (int) (Math.random() * 100);
            myList.add(value);
        }

        final QuickSort<Integer> quickSort = new QuickSort<>(myList);

        final ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(quickSort);


        if (!validate(myList)) {
            System.out.println("Should not happen");
        }

        printResult(myList);

    }

    private static boolean validate(List<Integer> myList) {
        for (int i = 0; i < myList.size() - 1; i++) {
            if (myList.get(i) > myList.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private static void printResult(List<Integer> myList) {
        for (int number : myList) {
            System.out.print(number);
            System.out.print(" ");
        }
        System.out.println();
    }
}
