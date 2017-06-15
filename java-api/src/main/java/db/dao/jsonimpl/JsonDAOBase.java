package db.dao.jsonimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import db.model.SizeCharts;
import exception.DAOException;

import java.io.File;
import java.io.IOException;

/**
 * Created by philippe on 15/06/17.
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
