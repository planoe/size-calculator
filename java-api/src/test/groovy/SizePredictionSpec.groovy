import api.SizePrediction
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.google.inject.Guice
import db.JsonSizeChartDAO
import db.model.SizeCharts
import io.dropwizard.jersey.params.IntParam
import resources.SizePredictionResource
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.any
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
        def om = new ObjectMapper()
        om.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        def sizeCharts = om.readValue(new File(testFilePath), SizeCharts.class)
        def sizeChartDAO = new JsonSizeChartDAO(sizeCharts)

        when:
        def actualSizes = sizeChartDAO.retrieveSizes(lookedUpBrand, lookedUpCategory, lookedUpMeasurement)

        then:
        // Compare regardless of order
        actualSizes.containsAll(expectedSizes) && expectedSizes.containsAll(actualSizes)

        where:
        testFilePath = "src/test/resources/brands.json"
        lookedUpBrand = "karl-lagarfeld"
        lookedUpCategory = "jeans"
        lookedUpMeasurement = 2
        expectedSizes = ["XS", "2"]
    }
}
