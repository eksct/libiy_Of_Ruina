package obj;

import java.io.Serializable;

/**
 * 
 * @TableName book
 */
public class Book implements Serializable {
    /**
     * 
     */
    private Integer bid;

    /**
     * 
     */
    private String bname;

    /**
     * 
     */
    private String author;

    /**
     * 
     */
    private Double price;

    private static final long serialVersionUID = 1L;

    public Book() {
    }

    public Book(Integer bid, String bname, String author, Double price) {
        this.bid = bid;
        this.bname = bname;
        this.author = author;
        this.price = price;
    }

    /**
     * 
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * 
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * 
     */
    public String getBname() {
        return bname;
    }

    /**
     * 
     */
    public void setBname(String bname) {
        this.bname = bname;
    }

    /**
     * 
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 
     */
    public void setPrice(Double price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Book other = (Book) that;
        return (this.getBid() == null ? other.getBid() == null : this.getBid().equals(other.getBid()))
                && (this.getBname() == null ? other.getBname() == null : this.getBname().equals(other.getBname()))
                && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
                && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBid() == null) ? 0 : getBid().hashCode());
        result = prime * result + ((getBname() == null) ? 0 : getBname().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bid=").append(bid);
        sb.append(", bname=").append(bname);
        sb.append(", author=").append(author);
        sb.append(", price=").append(price);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}