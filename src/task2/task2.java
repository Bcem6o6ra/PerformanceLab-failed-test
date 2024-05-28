import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class task2 {

    public static void main(String[] args){

        String fileWithCircle = args[0];
        String fileWithDots = args[1];


        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileWithCircle));
            String[] coordinates = reader.readLine().split(" ");

            BigDecimal circleX = new BigDecimal(coordinates[0]);
            BigDecimal circleY = new BigDecimal(coordinates[1]);

            BigDecimal circleRadius = new BigDecimal(reader.readLine());

            reader = new BufferedReader(new FileReader(fileWithDots));

            ArrayList<DotCoordinates> dotList = createDotArray(reader);

            ArrayList<String> result = new ArrayList<>();

            for (DotCoordinates coordinate : dotList) {

                BigDecimal subtractX = circleX.subtract(coordinate.getX());
                BigDecimal subtractY = circleY.subtract(coordinate.getY());

                BigDecimal subtractX2 = subtractX.multiply(subtractX);
                BigDecimal subtractY2 = subtractY.multiply(subtractY);

                BigDecimal rangeBetweenDots2 = subtractX2.add(subtractY2);

                BigDecimal circleRadius2 = circleRadius.multiply(circleRadius);

                if (rangeBetweenDots2.compareTo(circleRadius2) == -1) {
                    System.out.println("1");
                } else if (rangeBetweenDots2.compareTo(circleRadius2) == 0) {
                    System.out.println("0");
                } else { System.out.println("2"); }
            }
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    private static ArrayList<DotCoordinates> createDotArray(BufferedReader reader) throws IOException {

        ArrayList<DotCoordinates> dots = new ArrayList<>();
        String[] coordinates;
        while(reader.ready()) {
            coordinates = reader.readLine().split(" ");
            dots.add(new task2.DotCoordinates(coordinates));
        }
        return dots;
    }

    private static class DotCoordinates {

        private BigDecimal x, y;

        public DotCoordinates(String[] coordinates) {
            x = new BigDecimal(coordinates[0]);
            y = new BigDecimal(coordinates[1]);
        }

        public BigDecimal getX() {
            return x;
        }

        public BigDecimal getY() {
            return y;
        }
    }
}

