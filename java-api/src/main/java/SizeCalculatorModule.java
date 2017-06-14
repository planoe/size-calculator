import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.inject.AbstractModule;
import db.*;
import db.model.SizeCharts;

import java.io.File;
import java.io.IOException;

/**
 * Created by philippe on 11/06/17.
 */
public class SizeCalculatorModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(BrandDAO.class).to(JsonBrandDAO.class);
        bind(CategoryDAO.class).to(JsonCategoryDAO.class);
        bind(SizeChartDAO.class).to(JsonSizeChartDAO.class);

        ObjectMapper om = new ObjectMapper();
        om.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        try {
            SizeCharts s = om.readValue(new File("src/main/resources/data/test_data.json"), SizeCharts.class);
            bind(SizeCharts.class).toInstance(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
