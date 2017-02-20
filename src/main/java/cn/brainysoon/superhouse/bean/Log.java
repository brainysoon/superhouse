package cn.brainysoon.superhouse.bean;

import java.sql.Timestamp;

/**
 * Created by brainy on 17-2-20.
 */
public class Log {

    private String _id;
    private String manage_id;
    private String object_id;
    private Timestamp logdate;
    private String content;

    public String get_id() {
        return _id;
    }

    public String getManage_id() {
        return manage_id;
    }

    public String getObject_id() {
        return object_id;
    }

    public Timestamp getLogdate() {
        return logdate;
    }

    public String getContent() {
        return content;
    }

    public void setManage_id(String manage_id) {
        this.manage_id = manage_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public void setLogdate(Timestamp logdate) {
        this.logdate = logdate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
