import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class Values {

    @JsonProperty("values")
    ArrayList<Value> valuesList;

    @Override
    public String toString() {
        return "Values{" +
                "values=" + valuesList +
                '}';
    }
}