package planoe.sspinc

import planoe.sspinc.db.dao.jsonimpl.JsonCategoryDAO
import io.dropwizard.jersey.params.NonEmptyStringParam
import planoe.sspinc.resources.CategoryResource
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

/**
 * Created by philippe on 11/06/17.
 */
class CategorySpec extends Specification{

    def "CategoryResource provides list of all categories for a given brand"() {
        given:
        def fakeCategoryDAO  = mock(JsonCategoryDAO.class)
        when(fakeCategoryDAO.retrieveBrandCategories(anyString())).thenReturn(categories)
        def categoryResource = new CategoryResource(fakeCategoryDAO)

        when:
        def actualCategories = categoryResource.getCategoryRepository(lookedUpBrand)

        then:
        actualCategories.getCategoriesList() == categories

        where:
        lookedUpBrand = new NonEmptyStringParam("karl-lagarfeld")
        categories = [planoe.sspinc.api.Category.create("jeans", "Jeans", "waist")]
    }

    def "JsonCategoryDAO get correctly data from json file" () {
        given:
        def categoryDAO = new JsonCategoryDAO(testFilePath)

        when:
        def categories = categoryDAO.retrieveBrandCategories(lookedUpBrand)

        then:
        // Compare regardless of order
        categories.containsAll(expectedCategories) && expectedCategories.containsAll(categories)

        where:
        testFilePath="src/test/planoe.sspinc.resources/brands.json"
        lookedUpBrand = "karl-lagarfeld"
        expectedCategories=[planoe.sspinc.api.Category.create("jeans", "Jeans", "waist")]
    }
}
