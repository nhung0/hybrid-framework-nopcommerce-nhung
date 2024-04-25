package pageUIs;

public class HomePageUIs {
	//field/biến
	
	//1-public: 
	// không set protected vì các class bên ngoài package sẽ không dùng được=> không áp dụng kế thừa
	//không set private vì không dùng được ngoài class này
	// không set default vì ngoài package không dùng được
	// public: bất kì một cái class nào cũng gọi để sử dung được
	//convention: homepageobject sẽ chỉ gọi qua homepageuis
	
	// 2-static:
	//truy cập từ phạm vi class ở class khác được
	
	//3-final
	// không được phép thay đổi giá trị của biến khi sử dụng 
	// không nên thay đổi trong quá trình chạy
	
	// không có từ khóa nào đại diện cho hằng số
	// kết hợp 2 từ khóa với nhau = hằng số
	// static + final
	// tên biến của hằng số biết hoa và có dấu gạch nối
	
	//4 String: locator  xpath/css/id/name  là tham số của class by kiểu của by là String	
	
	//c: const; js: const let var 
	
	
	// 5- tên biến: 
	//tên của element+ loại element
	// textbox, textarea, radio, checkbox, image, text...
	
	public static final String REGISTER_LINK = "//a[@class='ico-register']";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
