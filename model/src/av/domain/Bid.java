package av.domain;

import javax.persistence.Entity;

@Entity
public class Bid {

    private Item item;

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
