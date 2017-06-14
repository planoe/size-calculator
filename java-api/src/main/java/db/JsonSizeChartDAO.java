package db;

import com.google.common.collect.ImmutableList;
import db.model.SizeCharts;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by philippe on 13/06/17.
 */
public class JsonSizeChartDAO implements SizeChartDAO {

    private final SizeCharts sizeCharts;

    @Inject
    public JsonSizeChartDAO(SizeCharts sizeCharts) {
        this.sizeCharts = sizeCharts;
    }

    @Override
    public List<String> retrieveSizes(String brandKey, String categoryKey, int measurement) {
        return sizeCharts.getBrands().stream()
                .filter(brand -> brand.getKey().equals(brandKey))
                .findAny()
                .get().getCategories().stream()
                .filter(category -> category.getKey().equals(categoryKey))
                .findAny()
                .get().getSizeCharts().stream()
                .filter(sizeChart -> sizeChart.getMeasurement() == measurement)
                .findAny()
                .map(sizeChart -> ImmutableList.of(sizeChart.getAlphaSize(), sizeChart.getSize()))
                .orElseGet(ImmutableList::of);
    }
}
