package db.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.Set;

/**
 * Created by philippe on 12/06/17.
 */
@AutoValue
@JsonDeserialize(builder = AutoValue_SizeCharts.Builder.class)
public abstract class SizeCharts {

    @JsonProperty
    public abstract Set<Brand> getBrands();

    public static Builder builder() {
        return new AutoValue_SizeCharts.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        @JsonProperty("brands")
        abstract Builder setBrands(Set<Brand> brands);

        abstract SizeCharts build();
    }

}
