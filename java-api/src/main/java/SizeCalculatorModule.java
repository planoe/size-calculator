import annotations.JsonFilePath;
import com.google.inject.AbstractModule;
import db.dao.*;
import db.dao.jsonimpl.JsonBrandDAO;
import db.dao.jsonimpl.JsonCategoryDAO;
import db.dao.jsonimpl.JsonSizeChartDAO;

/**
 * Created by philippe on 11/06/17.
 */
class SizeCalculatorModule extends AbstractModule{

    @Override
    protected void configure() {
        bindConstant().annotatedWith(JsonFilePath.class).to("src/main/resources/data/test_data.json");

        bind(BrandDAO.class).to(JsonBrandDAO.class);
        bind(CategoryDAO.class).to(JsonCategoryDAO.class);
        bind(SizeChartDAO.class).to(JsonSizeChartDAO.class);
    }
}
