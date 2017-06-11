package resources;

import api.BrandRepository;
import com.google.inject.Inject;
import db.BrandDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by philippe on 10/06/17.
 */
@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
public class BrandResource {

    private final BrandDAO brandDAO;

    @Inject
    public BrandResource(BrandDAO brandDAO) {
        this.brandDAO = brandDAO;
    }

    @GET
    public BrandRepository getBrandRepository() {
        return new BrandRepository(brandDAO.retrieveAll());
    }
}
