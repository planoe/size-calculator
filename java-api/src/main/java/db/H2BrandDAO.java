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
        brandsList.add(new Brand("calvin-klein", "Calvin Klein"));
        brandsList.add(new Brand("florence-eiseman", "Florence Eiseman"));
        return brandsList;
    }
}
