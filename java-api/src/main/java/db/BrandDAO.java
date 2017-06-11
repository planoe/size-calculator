package db;

import api.Brand;

import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
public interface BrandDAO {
    List<Brand> retrieveAll();
}
