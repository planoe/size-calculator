package resources;

import api.CategoryRepository;
import com.google.inject.Inject;
import db.CategoryDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

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
    public CategoryRepository getCategoryRepository(@QueryParam("brand") Optional<String> brand) {
        return new CategoryRepository(categoryDAO.retrieveBrandCategories(null));
    }
}
