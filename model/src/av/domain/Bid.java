package av.domain;

import javax.persistence.*;

@Entity
public class Bid {

    @Transient
    private Item item;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    public Bid(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
        item.getBids().add(this);
    }
}
