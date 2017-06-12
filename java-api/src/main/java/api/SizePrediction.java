package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.util.List;

@AutoValue
public abstract class SizePrediction {
    public static SizePrediction create(List<String> labels) {
        return new AutoValue_SizePrediction(SizeLabels.create(labels));
    }

    @JsonProperty("prediction")
    public abstract SizeLabels getSizeLabels();

    @AutoValue
    abstract static class SizeLabels {
        static SizeLabels create(List<String> labels) {
            return new AutoValue_SizePrediction_SizeLabels(ImmutableList.copyOf(labels));
        }

        @JsonProperty
        abstract ImmutableList<String> getLabels();
    }

}
