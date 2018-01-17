import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import av.domain.Item;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ModelOperaions {

    @Test
    public void testConstrains() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();


        Item item = new Item();

        item.setAuctionEnd(new Date());
        item.setName("Какое-то имя");


        Set<ConstraintViolation<Item>> violations = validator.validate(item);

        assertEquals(1, violations.size());


        ConstraintViolation<Item> violation = violations.iterator().next();

        assertEquals(violation.getPropertyPath(), "auctionEnd");


    }

}
