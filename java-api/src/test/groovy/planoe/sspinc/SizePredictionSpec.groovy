package planoe.sspinc

import planoe.sspinc.api.SizePrediction
import planoe.sspinc.db.dao.jsonimpl.JsonSizeChartDAO
import io.dropwizard.jersey.params.IntParam
import planoe.sspinc.resources.SizePredictionResource
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.anyInt
import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

/**
 * Created by philippe on 11/06/17.
 */
class SizePredictionSpec extends Specification{

    def "SizePredictionResource provides list of all sizes for a given brand, category and measurement"() {
        given:
        def fakeSizeChartDAO  = mock(JsonSizeChartDAO.class)
        when(fakeSizeChartDAO.retrieveSizes(anyString(),anyString(),anyInt())).thenReturn(sizes)
        def sizePredictionResource = new SizePredictionResource(fakeSizeChartDAO)

        when:
        def actualSizes = sizePredictionResource.predictSizeFrom(lookedUpBrand,lookedUpCategory,lookedUpMeasurement)

        then:
        actualSizes == SizePrediction.create(sizes)

        where:
        lookedUpBrand = "karl-lagarfeld"
        lookedUpCategory = "jeans"
        lookedUpMeasurement = new IntParam("4")
        sizes = ["S","4"]
    }

    def "JsonSizeChartDAO get correctly data from json file" () {
        given:
        def sizeChartDAO = new JsonSizeChartDAO(testFilePath)

        when:
        def actualSizes = sizeChartDAO.retrieveSizes(lookedUpBrand, lookedUpCategory, lookedUpMeasurement)

        then:
        // Compare regardless of order
        actualSizes.containsAll(expectedSizes) && expectedSizes.containsAll(actualSizes)

        where:
        testFilePath = "src/test/planoe.sspinc.resources/brands.json"
        lookedUpBrand = "karl-lagarfeld"
        lookedUpCategory = "jeans"
        lookedUpMeasurement = 2
        expectedSizes = ["XS", "2"]
    }
}
