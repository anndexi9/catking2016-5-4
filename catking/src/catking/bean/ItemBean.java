package catking.bean;

import java.io.Serializable;

public class ItemBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String category;
	private String sub_cat;
	private String brand;
	private int price;
	private String memo;
	private String datetime;
	private int qty;

	public ItemBean(int id, String name, String category, String sub_cat,
			String brand, int price, String memo, String datetime) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.sub_cat = sub_cat;
		this.brand = brand;
		this.price = price;
		this.memo = memo;
		this.datetime = datetime;
	}

	public ItemBean(int id, String name, int price, int qty) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

	public ItemBean() {

	}

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSub_cat() {
		return sub_cat;
	}

	public void setSub_cat(String sub_cat) {
		this.sub_cat = sub_cat;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
