package info.kinhho.karaoke.entity;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "account")
public class Account extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "permissions")
	private String permissions;
	
	@Column(name = "roles")
	private String roles;
	
	@Column(name = "signed_in_at")
	private ZonedDateTime signedInAt;
	
	@Column(name = "signed_out_at")
	private ZonedDateTime signedOutAt;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="account_id")
	private List<Bill> bills = new ArrayList<Bill>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private List<BookRoom> bookRooms = new ArrayList<BookRoom>();
	
	public Account() { }
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Account(Long id, String username, String password, String name, String permissions, String roles) {
		
		super.setId(id);
		this.username = username;
		this.password = password;
		this.name = name;
		this.permissions = permissions;
		this.roles = roles;
		this.active = 1;
		this.signedInAt = null;
		this.signedOutAt = null;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ZonedDateTime getSignedInAt() {
		return signedInAt;
	}

	public void setSignedInAt(ZonedDateTime signedInAt) {
		this.signedInAt = signedInAt;
	}

	public ZonedDateTime getSignedOutAt() {
		return signedOutAt;
	}

	public void setSignedOutAt(ZonedDateTime signedOutAt) {
		this.signedOutAt = signedOutAt;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	
	public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
	
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	
	public List<BookRoom> getBookRooms() {
		return bookRooms;
	}

	public void setBookRooms(List<BookRoom> bookRooms) {
		this.bookRooms = bookRooms;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", name=" + name + ", active=" + active
				+ ", permissions=" + permissions + ", roles=" + roles + ", signedInAt=" + signedInAt + ", signedOutAt="
				+ signedOutAt + ", bills=" + bills + ", id=" + id + "]";
	}
	
}
