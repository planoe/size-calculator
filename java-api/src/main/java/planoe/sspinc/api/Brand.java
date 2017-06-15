package planoe.sspinc.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Brand {

    @JsonProperty
    public abstract String getKey();
    @JsonProperty
    public abstract String getName();


    public static Brand create(String key, String name) {
        return Brand.builder().setKey(key).setName(name).build();
    }

    public static Builder builder() {
        return new AutoValue_Brand.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder setKey(String value);
        abstract Builder setName(String value);
        abstract Brand build();
    }
}
