package db;

import api.Category;
import db.model.SizeCharts;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by philippe on 13/06/17.
 */
public class JsonCategoryDAO implements CategoryDAO {

    private final SizeCharts sizeCharts;

    @Inject
    public JsonCategoryDAO(SizeCharts sizeCharts) {
        this.sizeCharts = sizeCharts;
    }
    @Override
    public List<Category> retrieveBrandCategories(String brandKey) {
        return sizeCharts.getBrands().stream()
                .filter(brand -> brand.getKey().equals(brandKey))
                .findAny()
                .get().getCategories().stream()
                .map(category -> Category.create(category.getKey(),category.getName(),category.getMeasurementType()))
                .collect(Collectors.toList());
    }
}
