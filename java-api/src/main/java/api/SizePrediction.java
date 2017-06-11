package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
public class SizePrediction {
    @JsonProperty("prediction")
    private final SizeLabels sizeLabels;

    public SizePrediction(List<String> labels) {
        this.sizeLabels = new SizeLabels(labels);
    }

    public SizeLabels getSizeLabels() {
        return sizeLabels;
    }

    private static class SizeLabels {
        @JsonProperty
        private final List<String> labels;

        private SizeLabels(List<String> labels) {
            this.labels = labels;
        }

        public List<String> getLabels() {
            return labels;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SizeLabels that = (SizeLabels) o;
            return Objects.equal(labels, that.labels);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(labels);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("labels", labels)
                    .toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizePrediction that = (SizePrediction) o;
        return Objects.equal(sizeLabels, that.sizeLabels);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sizeLabels);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("sizeLabels", sizeLabels)
                .toString();
    }
}
