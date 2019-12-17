package model;

public class Notice {
    private int id;
    private int uid;
    private int gid;
    private String time;

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
                ", time='" + time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
