import com.google.inject.AbstractModule;
import db.BrandDAO;
import db.CategoryDAO;
import db.H2BrandDAO;
import db.H2CategoryDAO;

/**
 * Created by philippe on 11/06/17.
 */
public class SizeCalculatorModule extends AbstractModule{
    protected void configure() {
        bind(BrandDAO.class).to(H2BrandDAO.class);
        bind(CategoryDAO.class).to(H2CategoryDAO.class);
    }
}
