package db;

import api.Brand;
import api.Category;

import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
public interface CategoryDAO {
    List<Category> retrieveBrandCategories(Brand brand);
}
