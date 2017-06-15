package planoe.sspinc

import planoe.sspinc.api.Category
import planoe.sspinc.db.dao.jsonimpl.JsonCategoryDAO
import planoe.sspinc.resources.CategoryResource
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.anyString
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

class CategorySpec extends Specification{

    def "CategoryResource provides list of all categories for a given brand"() {
        given:
        def fakeCategoryDAO  = mock(JsonCategoryDAO.class)
        when(fakeCategoryDAO.retrieveBrandCategories(anyString())).thenReturn(categories)
        def categoryResource = new CategoryResource(fakeCategoryDAO)

        when:
        def actualCategories = categoryResource.getAllCategoriesFromBrand(lookedUpBrand)

        then:
        actualCategories.getCategories() == categories

        where:
        lookedUpBrand = "karl-lagarfeld"
        categories = [Category.create("jeans", "Jeans", "waist")]
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
        testFilePath="src/test/resources/brands.json"
        lookedUpBrand = "karl-lagarfeld"
        expectedCategories=[Category.create("jeans", "Jeans", "waist")]
    }
}
