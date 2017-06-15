package db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

/**
 * Created by philippe on 14/06/17.
 */
@AutoValue
@JsonDeserialize(builder = AutoValue_SizeChart.Builder.class)
public abstract class SizeChart {
    @JsonProperty
    public abstract int getMeasurement();

    @JsonProperty
    public abstract String getSize();

    @JsonProperty
    public abstract String getAlphaSize();

    @AutoValue.Builder
    abstract static class Builder {
        @JsonProperty("measurement")
        abstract Builder setMeasurement(int measurement);

        @JsonProperty("size")
        abstract Builder setSize(String size);

        @JsonProperty("alpha_size")
        abstract Builder setAlphaSize(String alphaSize);

        abstract SizeChart build();
    }
}
