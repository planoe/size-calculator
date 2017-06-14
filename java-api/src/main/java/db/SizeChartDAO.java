package db;

import java.util.List;

/**
 * Created by philippe on 13/06/17.
 */
public interface SizeChartDAO {
    List<String> retrieveSizes(String brandKey, String categoryKey, int measurement);
}
