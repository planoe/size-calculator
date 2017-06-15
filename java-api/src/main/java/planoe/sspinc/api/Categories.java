package planoe.sspinc.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class Categories {

    public static Categories create(List<Category> categories) {
        return new AutoValue_Categories(categories);
    }

    @JsonProperty
    public abstract List<Category> getCategories();
}
