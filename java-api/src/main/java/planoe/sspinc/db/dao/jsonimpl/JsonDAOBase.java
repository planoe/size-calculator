package planoe.sspinc.db.dao.jsonimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import planoe.sspinc.db.model.SizeCharts;
import planoe.sspinc.exception.DAOException;

import java.io.File;
import java.io.IOException;

/**
 * Gather common operation for all DAOs related to JSON files
 */
class JsonDAOBase {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static {
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }

    private final String filePath;

    JsonDAOBase(String filePath) {
        this.filePath = filePath;
    }

    SizeCharts queryData() throws DAOException {
        try {
            return OBJECT_MAPPER.readValue(new File(filePath), SizeCharts.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DAOException("Json file " + filePath +" not available");
        }
    }
}
