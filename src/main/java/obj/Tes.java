package obj;


import java.io.Serializable;

/**
 * 
 * @TableName tes
 */

public class Tes implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String user;

    /**
     * 
     */
    private Integer pwd;


    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getuser() {
        return user;
    }

    /**
     * 
     */
    public void setuser(String user) {
        this.user = user;
    }

    /**
     * 
     */
    public Integer getpwd() {
        return pwd;
    }

    /**
     * 
     */
    public void setpwd(Integer pwd) {
        this.pwd = pwd;
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
        Tes other = (Tes) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getuser() == null ? other.getuser() == null : this.getuser().equals(other.getuser()))
            && (this.getpwd() == null ? other.getpwd() == null : this.getpwd().equals(other.getpwd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getuser() == null) ? 0 : getuser().hashCode());
        result = prime * result + ((getpwd() == null) ? 0 : getpwd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", pwd=").append(pwd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}