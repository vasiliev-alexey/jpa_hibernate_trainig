package av.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String firstname;
    private String lastname;
    protected Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
            @AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "BILLING_ZIP_CODE", length = 5)),

    })
    protected Address billingAddress;

}
