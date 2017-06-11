import com.google.inject.Guice
import io.dropwizard.jersey.params.IntParam
import resources.SizePredictionResource
import spock.lang.Specification

/**
 * Created by philippe on 11/06/17.
 */
class SizePredictionSpec extends Specification{
    def "Get prediction for a given brand and category"() {
        expect:
        sizePredictionResource.predictSizeFrom(brand, category, size).getSizeLabels().getLabels() == expectedSize

        where:
        brand = "calvin-klein"
        category = "dresses"
        size = new IntParam("31")
        sizePredictionResource = Guice.createInjector(new SizeCalculatorModule()).getInstance(SizePredictionResource.class)
        expectedSize = ["S", "4"]

    }
}
