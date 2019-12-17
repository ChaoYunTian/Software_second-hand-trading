package model;

public class Shopcar {
    private int id;
    private int uid;
    private int gid;

    @Override
    public String toString() {
        return "Shopcar{" +
                "id=" + id +
                ", uid=" + uid +
                ", gid=" + gid +
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
}
