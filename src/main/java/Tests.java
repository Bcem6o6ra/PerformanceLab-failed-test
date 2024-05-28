import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


@JsonAutoDetect
public class Tests {

    @JsonProperty("tests")
    ArrayList<Test> testsList;

    @Override
    public String toString() {
        return "Tests{" +
                "tests=" + testsList +
                '}';
    }

    public void InsertValue(Values dict) {
        for (Test test : testsList) {
            test.insertValue(dict);
        }
    }
}
