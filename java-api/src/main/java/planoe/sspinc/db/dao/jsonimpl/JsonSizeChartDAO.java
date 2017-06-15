package planoe.sspinc.db.dao.jsonimpl;

import planoe.sspinc.annotations.JsonFilePath;
import com.google.common.collect.ImmutableList;
import planoe.sspinc.db.dao.SizeChartDAO;
import planoe.sspinc.exception.DAOException;

import javax.inject.Inject;
import java.util.List;

public class JsonSizeChartDAO extends JsonDAOBase implements SizeChartDAO {

    @Inject
    public JsonSizeChartDAO(@JsonFilePath String jsonFilePath) {
        super(jsonFilePath);
    }

    @Override
    public List<String> retrieveSizes(String brandKey, String categoryKey, int measurement) throws DAOException {
        return queryData().getBrands().stream()
                .filter(brand -> brand.getKey().equals(brandKey))
                .findAny()
                .get().getCategories().stream()
                .filter(category -> category.getKey().equals(categoryKey))
                .findAny()
                .get().getSizeCharts().stream()
                .filter(sizeChart -> sizeChart.getMeasurement() == measurement)
                .findAny()
                .map(sizeChart -> ImmutableList.of(sizeChart.getAlphaSize(), sizeChart.getSize()))
                .orElseGet(ImmutableList::of);
    }
}
