package planoe.sspinc.db.dao;

import planoe.sspinc.exception.DAOException;

import java.util.List;

/**
 * DAO operations related to size predictions
 */
public interface SizeChartDAO {
    List<String> retrieveSizes(String brandKey, String categoryKey, int measurement) throws DAOException;
}
