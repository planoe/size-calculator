package resources;

import api.SizePrediction;
import exception.ObjectNotFoundException;
import io.dropwizard.jersey.params.IntParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

/**
 * Created by philippe on 11/06/17.
 */
@Path("/prediction")
@Produces(MediaType.APPLICATION_JSON)
public class SizePredictionResource {

    @GET
    public SizePrediction predictSizeFrom(@QueryParam("brand") String brand, @QueryParam("category") String category, @QueryParam("size") IntParam size) {
        System.out.println(brand+ "   " + category + "ttttttttttttt "+ size);
        if (size.get()==32) throw new ObjectNotFoundException("aa");
        return new SizePrediction(Arrays.asList("S", "4"));
    }
}
