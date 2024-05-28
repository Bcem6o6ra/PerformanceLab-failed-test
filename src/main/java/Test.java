import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class Test {

    public int id;


    public String title;

    public String value;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public ArrayList<Test> values;

    @JsonCreator
    public Test(
            @JsonProperty("id") int id
            , @JsonProperty("title") String title
            , @JsonProperty("value") String value
            , @JsonProperty("values") ArrayList<Test> values
    ) {
        this.id = id;
        this.title = title;
        if (value != null) {
            this.value = value;
        } else {
            this.value = "";
        }

        if (values != null) {
            System.out.println("Values != null");
            this.values = new ArrayList<Test>(values);
        } else {
            this.values = null;
        }
    }

    public void insertValue(Values dict) {
        for (Value value : dict.valuesList) {
            if (value.id == this.id) {
                this.value = value.value;
            }
            if (values != null) {
                for (Test test : values) {
                    test.insertValue(dict);
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                ", values=" + values +
                '}';
    }
}
