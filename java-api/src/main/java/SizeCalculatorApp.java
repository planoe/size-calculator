import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resources.BrandResource;
import resources.CategoryResource;
import resources.SizePredictionResource;

/**
 * Created by philippe on 10/06/17.
 */
public class SizeCalculatorApp extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new SizeCalculatorApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        GuiceBundle<Configuration> guiceBundle = GuiceBundle.newBuilder()
                .addModule(new SizeCalculatorModule())
                .setConfigClass(Configuration.class)
                .build();
        bootstrap.addBundle(guiceBundle);

        // Adding static assets
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }

    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.getObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        environment.jersey().register(BrandResource.class);
        environment.jersey().register(CategoryResource.class);
        environment.jersey().register(SizePredictionResource.class);
    }


}
