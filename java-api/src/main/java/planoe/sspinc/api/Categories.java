package planoe.sspinc.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.util.List;

@AutoValue
public abstract class Categories {

    public static Categories create(List<Category> categories) {
        return new AutoValue_Categories(ImmutableList.copyOf(categories));
    }

    @JsonProperty
    public abstract List<Category> getCategories();
}
