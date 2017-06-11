package api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
public class CategoryRepository {
    @JsonProperty
    private final List<Category> categories;

    public CategoryRepository(List<Category> categories) {
        this.categories = categories;
    }

    @JsonIgnore
    public List<Category> getCategoriesList() {
        return categories;
    }
}
