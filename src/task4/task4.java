import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class task4 {

    public static void main(String[] args) {

        String fileWithArray = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileWithArray));

            ArrayList<Integer> arrayList = new ArrayList<>();

            while (reader.ready()) {
                arrayList.add(Integer.parseInt(reader.readLine()));
            }

            Collections.sort(arrayList);

            int arrayLength = arrayList.size();
            int mediana;

            if (arrayLength % 2 == 0) {
                mediana = ((arrayList.get(arrayLength / 2) + arrayList.get(arrayLength / 2 + 1)) / 2);
            } else {
                mediana = arrayList.get(arrayLength / 2);
            }

            int result = 0;

            for (Integer i : arrayList) {
                result += Math.abs(mediana - i);
            }

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
