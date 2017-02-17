package cn.brainysoon.superhouse.bean;

import java.sql.Date;

/**
 * Created by brainy on 17-2-17.
 */
public class Staff {

    private String _id;
    private String staffname;
    private String password;
    private Date birthday;
    private Date datein;
    private int issuper;

    public String get_id() {
        return _id;
    }

    public String getStaffname() {
        return staffname;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getDatein() {
        return datein;
    }

    public int getIssuper() {
        return issuper;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setDatein(Date datein) {
        this.datein = datein;
    }

    public void setIssuper(int issuper) {
        this.issuper = issuper;
    }
}
