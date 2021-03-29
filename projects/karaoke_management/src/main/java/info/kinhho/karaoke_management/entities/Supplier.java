package info.kinhho.karaoke_management.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
	private List<Package> packages = new ArrayList<Package>();
	
	public Supplier() {}
	
	public Supplier(String name, String phone, String address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getJsonObject() {

		return String.format("{\"id\": %d, \"name\": \"%s\", \"phone\": \"%s\", \"address\": \"%s\"}",
				id, name, phone, address);
	}
}
