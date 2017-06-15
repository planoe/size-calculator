package planoe.sspinc.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
@AutoValue
public abstract class Brands {

    public static Brands create(List<Brand> brands) {
        return new AutoValue_Brands(brands);
    }

    @JsonProperty
    public abstract List<Brand> getBrands();
}
