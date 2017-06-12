package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Category {
    @JsonProperty
    public abstract String getKey();
    @JsonProperty
    public abstract String getName();
    @JsonProperty
    public abstract String getMeasurementType();

    public static Category create(String key, String name, String measurementType) {
        return Category.builder().setKey(key).setName(name).setMeasurementType(measurementType).build();
    }

    public static Category.Builder builder() {
        return new AutoValue_Category.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        abstract Category.Builder setKey(String value);
        abstract Category.Builder setName(String value);
        abstract Category.Builder setMeasurementType(String value);
        abstract Category build();
    }
}
