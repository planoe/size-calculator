package planoe.sspinc.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.util.List;

@AutoValue
public abstract class Brands {

    public static Brands create(List<Brand> brands) {
        return new AutoValue_Brands(ImmutableList.copyOf(brands));
    }

    @JsonProperty
    public abstract List<Brand> getBrands();
}
