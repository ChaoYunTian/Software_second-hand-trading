package model;

public class Goods {
    private int id;
    private String name;
    private String campus;
    private String quality;
    private String price;
    private String tel;
    private String remark;
    private String thingimg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getThingimg() {
		return thingimg;
	}
	public void setThingimg(String thingimg) {
		this.thingimg = thingimg;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", campus=" + campus + ", quality=" + quality + ", price=" + price
				+ ", tel=" + tel + ", remark=" + remark + ", thingimg=" + thingimg + "]";
	}
   
}
