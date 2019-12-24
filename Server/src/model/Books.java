package model;

public class Books {
	private String bookname;
	private String author;
	private String publish;
	private String price;
	private String jiaofu;
	private String campus;
	private String quality;
	private String bookimg;
	public String getBookimg() {
		return bookimg;
	}
	public void setBookimg(String bookimg) {
		this.bookimg = bookimg;
	}
	@Override
	public String toString() {
		return "Books [bookname=" + bookname + ", author=" + author + ", publish=" + publish + ", price=" + price
				+ ", jiaofu=" + jiaofu + ", campus=" + campus + ", quality=" + quality + ", bookimg=" + bookimg
				+ ", tel=" + tel + ", remark=" + remark + "]";
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getJiaofu() {
		return jiaofu;
	}
	public void setJiaofu(String jiaofu) {
		this.jiaofu = jiaofu;
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
