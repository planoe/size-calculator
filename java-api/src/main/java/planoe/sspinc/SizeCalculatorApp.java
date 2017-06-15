package planoe.sspinc;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by philippe on 10/06/17.
 */
public class SizeCalculatorApp extends Application<SizeCalculatorConfiguration> {

    public static void main(String[] args) throws Exception {
        new SizeCalculatorApp().run(args);
    }

    @Override
    public void initialize(Bootstrap<SizeCalculatorConfiguration> bootstrap) {
        GuiceBundle<SizeCalculatorConfiguration> guiceBundle = GuiceBundle.<SizeCalculatorConfiguration>newBuilder()
                .addModule(new SizeCalculatorModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(SizeCalculatorConfiguration.class)
                .build();
        bootstrap.addBundle(guiceBundle);

        // Adding static assets
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }

    public void run(SizeCalculatorConfiguration configuration, Environment environment) throws Exception {
        environment.getObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    }


}
