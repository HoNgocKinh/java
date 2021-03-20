package info.kinhho.karaoke_management.dtos;

public class SupplierDTO extends BaseDTO {
	
	private String name;
	private String address;
	private String phone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return String.format("{\"id\": \"%s\", "
				+ "\"name\": \"%s\", "
				+ "\"phone\": \"%s\", "
				+ "\"address\": \"%s\"}", id, name, phone, address);
	}
}
