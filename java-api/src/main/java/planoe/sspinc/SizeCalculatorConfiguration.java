package planoe.sspinc;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

class SizeCalculatorConfiguration extends Configuration {

    @JsonProperty
    private String jsonFilePath;

    String getJsonFilePath() {
        return jsonFilePath;
    }

    void setJsonFilePath(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }
}
