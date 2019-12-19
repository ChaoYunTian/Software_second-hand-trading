package model;

public class UserAddress {
   private String name;
   private String tel;
   private String province;
   private String city;
   private String county;
   private String address;
@Override
public String toString() {
	return "UserAddress [name=" + name + ", tel=" + tel + ", province=" + province + ", city=" + city + ", county="
			+ county + ", address=" + address + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCounty() {
	return county;
}
public void setCounty(String county) {
	this.county = county;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
}
