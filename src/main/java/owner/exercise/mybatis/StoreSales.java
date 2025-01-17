package owner.exercise.mybatis;

public class StoreSales {

	private int store_id;
	private String salesperson;
	private int sales;
	public int getStoreId() {
		return store_id;
	}
	public void setStoreId(int sotreId) {
		this.store_id = sotreId;
	}
	public String getSalesperson() {
		return salesperson;
	}
	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	@Override
	public String toString() {
		return "StoreSales [storeId=" + store_id + ", salesperson=" + salesperson + ", sales=" + sales + "]";
	}
	
	
}
