import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.Optional;

public class AccessJPAMetamodel {

    @Test
    public void testMetaModel() {


        EntityManagerFactory factory= Persistence.createEntityManagerFactory("CaveatEmptorPU");


        Metamodel metamodel  = factory.getMetamodel();

        metamodel.getEntities().forEach( v -> System.out.println(v.getPersistenceType()));





    }

}
