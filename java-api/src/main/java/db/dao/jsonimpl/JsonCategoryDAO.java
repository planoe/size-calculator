package db.dao.jsonimpl;

import annotations.JsonFilePath;
import api.Category;
import db.dao.CategoryDAO;
import exception.DAOException;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by philippe on 13/06/17.
 */
public class JsonCategoryDAO extends JsonDAOBase implements CategoryDAO {

    @Inject
    public JsonCategoryDAO(@JsonFilePath String jsonFilePath) {
        super(jsonFilePath);
    }

    @Override
    public List<Category> retrieveBrandCategories(String brandKey) throws DAOException {
        return queryData().getBrands().stream()
                .filter(brand -> brand.getKey().equals(brandKey))
                .findAny()
                .get().getCategories().stream()
                .map(category -> Category.create(category.getKey(),category.getName(),category.getMeasurementType()))
                .collect(Collectors.toList());
    }
}
