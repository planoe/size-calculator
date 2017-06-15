package planoe.sspinc.db.dao;

import planoe.sspinc.api.Category;
import planoe.sspinc.exception.DAOException;

import java.util.List;

/**
 * DAO operations related to categories
 */
public interface CategoryDAO {
    List<Category> retrieveBrandCategories(String brandKey) throws DAOException;
}
