package db;

import api.Brand;
import db.model.SizeCharts;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by philippe on 13/06/17.
 */
public class JsonBrandDAO implements BrandDAO {

    private final SizeCharts sizeCharts;

    @Inject
    public JsonBrandDAO(SizeCharts sizeCharts) {
        this.sizeCharts = sizeCharts;
    }

    @Override
    public List<Brand> retrieveAll() {
        return sizeCharts.getBrands().stream()
                .map( brand -> Brand.create(brand.getKey(), brand.getName()))
                .collect(Collectors.toList());
    }
}
