package planoe.sspinc.db.dao;

import planoe.sspinc.api.Category;
import planoe.sspinc.exception.DAOException;

import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
public interface CategoryDAO {
    List<Category> retrieveBrandCategories(String brandKey) throws DAOException;
}
