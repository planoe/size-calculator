package resources;

import api.SizePrediction;
import com.google.inject.Inject;
import db.dao.SizeChartDAO;
import exception.DAOException;
import exception.ObjectNotFoundException;
import io.dropwizard.jersey.params.IntParam;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.valuehandling.UnwrapValidatedValue;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by philippe on 11/06/17.
 */
@Path("/prediction")
@Produces(MediaType.APPLICATION_JSON)
public class SizePredictionResource {

    private final SizeChartDAO sizeChartDAO;

    @Inject
    public SizePredictionResource(SizeChartDAO sizeChartDAO) {
        this.sizeChartDAO = sizeChartDAO;
    }

    @GET
    public SizePrediction predictSizeFrom(@QueryParam("brand") @NotEmpty String brandKey, @QueryParam("category") @NotEmpty String categoryKey, @QueryParam("size") @NotNull @UnwrapValidatedValue(false) IntParam measurement) {
        List<String> result;
        try {
            result = sizeChartDAO.retrieveSizes(brandKey, categoryKey, measurement.get());
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ObjectNotFoundException("Data is currently unavailable");
        }
        if (result.isEmpty()) throw new ObjectNotFoundException("Size not available");
        return SizePrediction.create(result);
    }
}
