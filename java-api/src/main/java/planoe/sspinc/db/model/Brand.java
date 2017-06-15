package planoe.sspinc.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Created by philippe on 14/06/17.
 */
@AutoValue
@JsonDeserialize(builder = AutoValue_Brand.Builder.class)
public abstract class Brand {

    @JsonProperty
    public abstract String getKey();

    @JsonProperty
    public abstract String getName();

    @JsonProperty
    public abstract List<Category> getCategories();

    @AutoValue.Builder
    abstract static class Builder {
        @JsonProperty("key")
        abstract Builder setKey(String key);

        @JsonProperty("name")
        abstract Builder setName(String name);

        @JsonProperty("categories")
        abstract Builder setCategories(List<Category> categories);

        abstract Brand build();
    }

}
