import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        final int q = (int) Math.sqrt(num);
        for (int i = 2; i <= q; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("task 1 was completed, IJ was installed\n");
        System.out.println("task 2\n");
        final int n = 20;
        ArrayList<Double> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            list.add(Math.random());
        }

        Collections.sort(list);
        System.out.println("minimal value of arraylist is " + list.get(0));
        System.out.println("maximal value of arraylist is " + list.get(n - 1));
        System.out.println("average value of arraylist is " + list.get(n / 2) + '\n');
        System.out.println("task 3\n");

        for (int num = 2; num < 100; num++) {
            if (isPrime(num)) {
                System.out.println(num + " is prime number");
            }
        }
    }
}