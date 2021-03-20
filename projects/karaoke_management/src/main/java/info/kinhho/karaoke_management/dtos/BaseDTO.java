package info.kinhho.karaoke_management.dtos;

import java.time.ZonedDateTime;

public class BaseDTO {
	
	protected Long id;
	protected ZonedDateTime createdAt;
	protected ZonedDateTime updateAt;
	protected boolean active;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public ZonedDateTime getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(ZonedDateTime updateAt) {
		this.updateAt = updateAt;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
