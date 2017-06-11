import api.Brand
import com.google.inject.Guice
import resources.BrandResource
import spock.lang.Specification

/**
 * Created by philippe on 10/06/17.
 */
class BrandSpec extends Specification{
    def "Get list of brands"() {
        expect:

        brandResource.getBrandRepository().getBrandsList() == expectedBrands

        where:
        brandResource = Guice.createInjector(new SizeCalculatorModule()).getInstance(BrandResource.class)
        expectedBrands = Arrays.asList(
                new Brand("calvin-klein", "Calvin Klein"),
                new Brand("florence-eiseman", "Florence Eiseman"))
    }
}
