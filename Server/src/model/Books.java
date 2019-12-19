package model;

public class Books {
	private String bookname;
	private String author;
	private String publish;
	private float price;
	private int jiaofu;
	private String campus;
	private int quality;
	@Override
	public String toString() {
		return "Books [bookname=" + bookname + ", author=" + author + ", publish=" + publish + ", price=" + price
				+ ", jiaofu=" + jiaofu + ", campus=" + campus + ", quality=" + quality + ", tel=" + tel + ", remark="
				+ remark + "]";
	}
	private String tel;
	private String remark;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getJiaofu() {
		return jiaofu;
	}
	public void setJiaofu(int jiaofu) {
		this.jiaofu = jiaofu;
	}
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
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
	
}
