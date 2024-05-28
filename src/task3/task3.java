import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class task3 {


    public static void main(String[] args) {
        ObjectMapper valuesMapper = new ObjectMapper();
        ObjectMapper testMapper = new ObjectMapper();

        try {
            BufferedReader valuesReader = new BufferedReader(new FileReader("C:\\Users\\Павел\\Desktop\\values.json"));
            String valuesString = new String();
            while (valuesReader.ready()) {
                valuesString += valuesReader.readLine();
            }

            Values value1 = valuesMapper.readValue(valuesString, Values.class);

            BufferedReader testReader = new BufferedReader(new FileReader("C:\\Users\\Павел\\Desktop\\tests.json"));
            String testString = new String();
            while (testReader.ready()) {
                testString += testReader.readLine();
            }

            Tests test1 = testMapper.readValue(testString, Tests.class);

            System.out.println("Результат: " + test1);
            test1.InsertValue(value1);
            System.out.println("Результат с добавленными value: " + test1);

            FileWriter writer = new FileWriter("C:\\Users\\Павел\\Desktop\\report.json");

            testMapper.writeValue(writer, test1);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}





