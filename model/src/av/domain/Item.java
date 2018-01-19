package av.domain;

import av.domain.enums.AuctionType;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @NotNull
    @Size(min = 2, max = 255, message = "Не верная длина имени минимум 2 максимум 255")
    private String name;
    private String description;
    private Date createdOn;
    private boolean verified;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuctionType auctionType;
    private BigDecimal initialPrice;
    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionStart;
    @Future
    @Temporal(TemporalType.TIMESTAMP)
    private Date auctionEnd;
    @Transient
    private Set<Bid> bids = new HashSet<Bid>();


    public void addBid(Bid bid) {

        if (bid == null) throw new NullPointerException("Передано пустое предложение");

        if (bid.getItem() != null) throw new IllegalStateException("Предложению уже назначен лот");

        getBids().add(bid);
        bid.setItem(this);


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public AuctionType getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(AuctionType auctionType) {
        this.auctionType = auctionType;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Date getAuctionStart() {
        return auctionStart;
    }

    public void setAuctionStart(Date auctionStart) {
        this.auctionStart = auctionStart;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
}
