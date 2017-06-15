package db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Created by philippe on 14/06/17.
 */
@AutoValue
@JsonDeserialize(builder = AutoValue_Category.Builder.class)
public abstract class Category {
    @JsonProperty
    public abstract String getKey();

    @JsonProperty
    public abstract String getName();

    @JsonProperty
    public abstract String getMeasurementType();

    @JsonProperty
    public abstract List<SizeChart> getSizeCharts();

    @AutoValue.Builder
    abstract static class Builder {
        @JsonProperty("key")
        abstract Builder setKey(String key);

        @JsonProperty("name")
        abstract Builder setName(String name);

        @JsonProperty("measurement_type")
        abstract Builder setMeasurementType(String measurementType);

        @JsonProperty("size_charts")
        abstract Builder setSizeCharts(List<SizeChart> sizeCharts);

        abstract Category build();
    }

}
