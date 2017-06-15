package db.dao;

import api.Category;
import exception.DAOException;

import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
public interface CategoryDAO {
    List<Category> retrieveBrandCategories(String brandKey) throws DAOException;
}
