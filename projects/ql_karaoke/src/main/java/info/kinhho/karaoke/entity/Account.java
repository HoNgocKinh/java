package info.kinhho.karaoke.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;


@Entity
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
		
	private String username;
	private String password;
	private String name;
	private int active;
	private String permissions;
	private String roles;
	private Date timeLoggined;
	private Date timeLogouted;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="account_id")
	private List<Bill> bills;
	
	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account() {
		
	}
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Account(Integer id, String username, String password, String name, String permissions, String roles) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.permissions = permissions;
		this.roles = roles;
		this.active = 1;
		this.timeLoggined = null;
		this.timeLogouted = null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getTimeLoggined() {
		return timeLoggined;
	}
	public void setTimeLoggined(Date timeLoggined) {
		this.timeLoggined = timeLoggined;
	}
	public Date getTimeLogouted() {
		return timeLogouted;
	}
	public void setTimeLogouted(Date timeLogouted) {
		this.timeLogouted = timeLogouted;
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

	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", timeLoggined=" + timeLoggined + ", timeLogouted=" + timeLogouted + ", bills=" + bills + "]";
	}
	
	
	
}
