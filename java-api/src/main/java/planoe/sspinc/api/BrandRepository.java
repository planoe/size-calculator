package planoe.sspinc.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
public class BrandRepository {
    @JsonProperty
    private final List<Brand> brands;

    public BrandRepository(List<Brand> brands) {
        this.brands = brands;
    }

    @JsonIgnore
    public List<Brand> getBrandsList() {
        return brands;
    }
}
