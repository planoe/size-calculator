import api.Brand
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.google.common.collect.ImmutableList
import db.JsonBrandDAO
import db.model.SizeCharts
import resources.BrandResource
import spock.lang.Specification

import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

/**
 * Created by philippe on 10/06/17.
 */
class BrandSpec extends Specification{

    def "BrandResource provides list of all brands"() {
        given:
        def FAKE_BRAND_DAO  = mock(JsonBrandDAO.class)
        when(FAKE_BRAND_DAO.retrieveAll()).thenReturn(brands)
        def brandResource = new BrandResource(FAKE_BRAND_DAO)

        when:
        def actualBrands = brandResource.getBrands().getBrandsList()

        then:
        actualBrands == brands

        where:
        brands = [Brand.create("calvin-klein", "Calvin Klein"),
                  Brand.create("florence-eiseman", "Florence Eiseman")]
    }

    def "JsonBrandDAO get correctly data from json file" () {
        given:
        def om = new ObjectMapper();
        om.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        def sizeCharts = om.readValue(new File(testFilePath), SizeCharts.class)
        def brandDAO = new JsonBrandDAO(sizeCharts)

        when:
        def brands = brandDAO.retrieveAll()

        then:
        // Compare regardless of order
        brands.containsAll(expectedBrands) && expectedBrands.containsAll(brands)

        where:
        testFilePath="src/test/resources/brands.json"
        expectedBrands=[api.Brand.create("calvin-klein", "Calvin Klein"),
                        api.Brand.create("karl-lagarfeld", "Karl Lagarfeld")]
    }


}
