package db;

import api.Brand;
import api.Category;

import java.util.Arrays;
import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
public class H2CategoryDAO implements CategoryDAO {
    @Override
    public List<Category> retrieveBrandCategories(Brand brand) {
        return Arrays.asList(
                new Category("dresses", "Dresses", "bust"),
                new Category("jeans", "Jeans", "waist"));
    }
}