package info.kinhho.karaoke_management.entities;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;

@Inheritance
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(name = "created_at")
	protected ZonedDateTime createdAt = ZonedDateTime.now();
	
	@Column(name = "updated_at")
	protected ZonedDateTime updatedAt = ZonedDateTime.now();
	
	@Column(name = "active")
	protected boolean active = true;
	
	@Column(name = "json_string")
	protected String jsonObject;
	
	protected transient DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm O");
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt.format(formatter);
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt.format(formatter);
	}

	public void setUpdatedAt(ZonedDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void setJsonObject(String jsonObject) {
		this.jsonObject = jsonObject;
	}
	
	public abstract String getJsonObject();
}
