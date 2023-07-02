package obj;

import java.io.Serializable;

/**
 * 
 * @TableName student
 */

public class Student implements Serializable {
    /**
     * 
     */

    private Integer sid;

    /**
     * 
     */
    private String sname;

    /**
     * 
     */
    private Object sex;


    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * 
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * 
     */
    public String getSname() {
        return sname;
    }

    /**
     * 
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

    /**
     * 
     */
    public Object getSex() {
        return sex;
    }

    /**
     * 
     */
    public void setSex(Object sex) {
        this.sex = sex;
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
        Student other = (Student) that;
        return (this.getSid() == null ? other.getSid() == null : this.getSid().equals(other.getSid()))
                && (this.getSname() == null ? other.getSname() == null : this.getSname().equals(other.getSname()))
                && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSid() == null) ? 0 : getSid().hashCode());
        result = prime * result + ((getSname() == null) ? 0 : getSname().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sid=").append(sid);
        sb.append(", sname=").append(sname);
        sb.append(", sex=").append(sex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}