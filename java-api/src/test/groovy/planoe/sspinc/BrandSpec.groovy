package planoe.sspinc

import planoe.sspinc.api.Brand
import planoe.sspinc.db.dao.jsonimpl.JsonBrandDAO
import planoe.sspinc.resources.BrandResource
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
        def actualBrands = brandResource.getAllBrands()

        then:
        actualBrands.getBrands() == brands

        where:
        brands = [Brand.create("calvin-klein", "Calvin Klein"),
                  Brand.create("florence-eiseman", "Florence Eiseman")]
    }

    def "JsonBrandDAO get correctly data from json file" () {
        given:
        def brandDAO = new JsonBrandDAO(testFilePath)

        when:
        def brands = brandDAO.retrieveAll()

        then:
        // Compare regardless of order
        brands.containsAll(expectedBrands) && expectedBrands.containsAll(brands)

        where:
        testFilePath="src/test/resources/brands.json"
        expectedBrands=[Brand.create("calvin-klein", "Calvin Klein"),
                        Brand.create("karl-lagarfeld", "Karl Lagarfeld")]
    }


}
