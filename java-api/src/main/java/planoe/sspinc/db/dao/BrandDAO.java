package planoe.sspinc.db.dao;

import planoe.sspinc.api.Brand;
import planoe.sspinc.exception.DAOException;

import java.util.List;

/**
 * DAO operations related to brands
 */
public interface BrandDAO {
    List<Brand> retrieveAll() throws DAOException;
}
