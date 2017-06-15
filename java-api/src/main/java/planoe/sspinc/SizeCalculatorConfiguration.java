package planoe.sspinc;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

/**
 * Created by philippe on 15/06/17.
 */
public class SizeCalculatorConfiguration extends Configuration {

    @JsonProperty
    private String jsonFilePath;

    public String getJsonFilePath() {
        return jsonFilePath;
    }

    public void setJsonFilePath(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }
}
