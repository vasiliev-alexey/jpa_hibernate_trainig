package domain;

import domain.enums.AuctionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Item {

    private String name;
    private String description;
    private Date createdOn;
    private boolean verified;
    private AuctionType auctionType;
    private BigDecimal initialPrice;

    private Date auctionStart;
    private Date auctionEnd;
    private Set<Bid>  bids = new HashSet<Bid>();


    public  void addBid(Bid bid) {

        if(bid == null) throw new NullPointerException("Передано пустое предложение");


    }

}
