package db;

import api.Brand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
public class H2BrandDAO implements BrandDAO{

    @Override
    public List<Brand> retrieveAll() {
        List<Brand> brandsList = new ArrayList<>();
        brandsList.add(Brand.create("calvin-klein", "Calvin Klein"));
        brandsList.add(Brand.create("florence-eiseman", "Florence Eiseman"));
        return brandsList;
    }
}
