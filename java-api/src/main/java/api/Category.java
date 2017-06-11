package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * Created by philippe on 11/06/17.
 */
public class Category {
    @JsonProperty
    private final String key;
    @JsonProperty
    private final String name;
    @JsonProperty
    private final String measurementType;

    public Category(String key, String name, String measurementType) {
        this.key = key;
        this.name = name;
        this.measurementType = measurementType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equal(key, category.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("key", key)
                .add("name", name)
                .add("measurementType", measurementType)
                .toString();
    }
}
