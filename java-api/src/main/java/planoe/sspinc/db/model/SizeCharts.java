package planoe.sspinc.db.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
@JsonDeserialize(builder = AutoValue_SizeCharts.Builder.class)
public abstract class SizeCharts {

    @JsonProperty
    public abstract List<Brand> getBrands();

    @AutoValue.Builder
    abstract static class Builder {
        @JsonProperty("brands")
        abstract Builder setBrands(List<Brand> brands);
        abstract SizeCharts build();
    }

}
