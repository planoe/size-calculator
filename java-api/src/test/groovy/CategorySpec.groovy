import api.Category
import com.google.inject.Guice
import resources.CategoryResource
import spock.lang.Specification

/**
 * Created by philippe on 11/06/17.
 */
class CategorySpec extends Specification{
    def "Get list of categories"() {
        expect:
        categoryResource.getCategoryRepository().getCategoriesList() == expectedCategories

        where:
        categoryResource = Guice.createInjector(new SizeCalculatorModule()).getInstance(CategoryResource.class)
        expectedCategories = Arrays.asList(
                new Category("dresses", "Dresses", "bust"),
                new Category("jeans", "Jeans", "waist"))
    }
}
