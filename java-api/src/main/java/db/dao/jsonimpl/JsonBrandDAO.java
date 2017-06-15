package db.dao.jsonimpl;

import annotations.JsonFilePath;
import api.Brand;
import db.dao.BrandDAO;
import exception.DAOException;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by philippe on 13/06/17.
 */
public class JsonBrandDAO extends JsonDAOBase implements BrandDAO {

    @Inject
    public JsonBrandDAO(@JsonFilePath String jsonFilePath) {
        super(jsonFilePath);
    }

    @Override
    public List<Brand> retrieveAll() throws DAOException{
        return queryData().getBrands().stream()
            .map( brand -> Brand.create(brand.getKey(), brand.getName()))
            .collect(Collectors.toList());
    }
}
