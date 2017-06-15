package planoe.sspinc.resources;

import planoe.sspinc.api.Categories;
import com.google.inject.Inject;
import planoe.sspinc.db.dao.CategoryDAO;
import planoe.sspinc.exception.DAOException;
import planoe.sspinc.exception.ObjectNotFoundException;
import org.hibernate.validator.constraints.NotEmpty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by philippe on 11/06/17.
 */
@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {
    private final CategoryDAO categoryDAO;

    @Inject
    public CategoryResource(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @GET
    public Categories getAllCategoriesFromBrand(@QueryParam("brand") @NotEmpty String brandKey) {
        try {
            return Categories.create(categoryDAO.retrieveBrandCategories(brandKey));
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ObjectNotFoundException("Data source currently unavailable");
        }
    }
}
