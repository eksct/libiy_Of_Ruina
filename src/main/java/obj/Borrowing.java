package obj;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName borrowing
 */
public class Borrowing implements Serializable {
    /**
     * 
     */
    private Integer bosid;

    /**
     * 
     */
    private Integer bobid;

    /**
     * 
     */
    private Date time;
    private String studentName;
    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getBosid() {
        return bosid;
    }

    /**
     * 
     */
    public void setBosid(Integer bosid) {
        this.bosid = bosid;
    }

    /**
     * 
     */
    public Integer getBobid() {
        return bobid;
    }

    /**
     * 
     */
    public void setBobid(Integer bobid) {
        this.bobid = bobid;
    }

    /**
     * 
     */
    public Date getTime() {
        return time;
    }

    /**
     * 
     */
    public void setTime(Date time) {
        this.time = time;
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
        Borrowing other = (Borrowing) that;
        return (this.getBosid() == null ? other.getBosid() == null : this.getBosid().equals(other.getBosid()))
                && (this.getBobid() == null ? other.getBobid() == null : this.getBobid().equals(other.getBobid()))
                && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBosid() == null) ? 0 : getBosid().hashCode());
        result = prime * result + ((getBobid() == null) ? 0 : getBobid().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bosid=").append(bosid);
        sb.append(", bookName=").append(bookName);
        sb.append(",studentName=").append(studentName);
        sb.append(", bobid=").append(bobid);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}

