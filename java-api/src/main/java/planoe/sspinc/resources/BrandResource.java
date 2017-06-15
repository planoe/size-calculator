package planoe.sspinc.resources;

import planoe.sspinc.api.Brands;
import com.google.inject.Inject;
import planoe.sspinc.db.dao.BrandDAO;
import planoe.sspinc.exception.DAOException;
import planoe.sspinc.exception.ObjectNotFoundException;

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
    public Brands getAllBrands() {
        try {
            return Brands.create(brandDAO.retrieveAll());
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ObjectNotFoundException("Data source is currently unavailable");
        }
    }
}
