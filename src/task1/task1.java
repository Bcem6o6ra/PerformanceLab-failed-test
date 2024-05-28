import java.util.ArrayList;

public class task1 {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        ArrayList<Integer> result = new ArrayList<>();
        int i = 1;
        do {
            if (i % n == 0) {
                result.add(n);
            } else {
                result.add(i % n);
            }
            i += m - 1;
        } while (i % n != 1);
        System.out.println(result);
    }
}
