package planoe.sspinc.db.dao.jsonimpl;

import planoe.sspinc.annotations.JsonFilePath;
import planoe.sspinc.api.Category;
import planoe.sspinc.db.dao.CategoryDAO;
import planoe.sspinc.exception.DAOException;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

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
