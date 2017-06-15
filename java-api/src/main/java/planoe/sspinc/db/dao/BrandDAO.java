package planoe.sspinc.db.dao;

import planoe.sspinc.api.Brand;
import planoe.sspinc.exception.DAOException;

import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
public interface BrandDAO {
    List<Brand> retrieveAll() throws DAOException;
}
