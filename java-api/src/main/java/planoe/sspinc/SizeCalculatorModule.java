package planoe.sspinc;

import com.google.inject.Provides;
import planoe.sspinc.annotations.JsonFilePath;
import com.google.inject.AbstractModule;
import planoe.sspinc.db.dao.BrandDAO;
import planoe.sspinc.db.dao.CategoryDAO;
import planoe.sspinc.db.dao.SizeChartDAO;
import planoe.sspinc.db.dao.jsonimpl.JsonBrandDAO;
import planoe.sspinc.db.dao.jsonimpl.JsonCategoryDAO;
import planoe.sspinc.db.dao.jsonimpl.JsonSizeChartDAO;

/**
 * Created by philippe on 11/06/17.
 */
class SizeCalculatorModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(BrandDAO.class).to(JsonBrandDAO.class);
        bind(CategoryDAO.class).to(JsonCategoryDAO.class);
        bind(SizeChartDAO.class).to(JsonSizeChartDAO.class);
    }

    @Provides
    @JsonFilePath
    public String provideJsonPath(SizeCalculatorConfiguration config){
        return config.getJsonFilePath();
    }

}
