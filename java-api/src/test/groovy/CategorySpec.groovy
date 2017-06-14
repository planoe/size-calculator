import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import db.JsonCategoryDAO
import db.model.SizeCharts
import io.dropwizard.jersey.params.NonEmptyStringParam
import resources.CategoryResource
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.any
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

/**
 * Created by philippe on 11/06/17.
 */
class CategorySpec extends Specification{

    def "CategoryResource provides list of all categories for a given brand"() {
        given:
        def fakeCategoryDAO  = mock(JsonCategoryDAO.class)
        when(fakeCategoryDAO.retrieveBrandCategories(any())).thenReturn(categories)
        def categoryResource = new CategoryResource(fakeCategoryDAO)

        when:
        def actualCategories = categoryResource.getCategoryRepository(lookedUpBrand)

        then:
        actualCategories.getCategoriesList() == categories

        where:
        lookedUpBrand = new NonEmptyStringParam("karl-lagarfeld")
        categories = [api.Category.create("jeans", "Jeans", "waist")]
    }

    def "JsonCategoryDAO get correctly data from json file" () {
        given:
        def om = new ObjectMapper()
        om.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        def sizeCharts = om.readValue(new File(testFilePath), SizeCharts.class)
        def categoryDAO = new JsonCategoryDAO(sizeCharts)

        when:
        def categories = categoryDAO.retrieveBrandCategories(lookedUpBrand)

        then:
        // Compare regardless of order
        categories.containsAll(expectedCategories) && expectedCategories.containsAll(categories)

        where:
        testFilePath="src/test/resources/brands.json"
        lookedUpBrand = "karl-lagarfeld"
        expectedCategories=[api.Category.create("jeans", "Jeans", "waist")]
    }
}
