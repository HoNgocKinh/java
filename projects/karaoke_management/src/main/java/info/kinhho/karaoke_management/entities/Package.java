package info.kinhho.karaoke_management.entities;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "package")
public class Package extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "exp_at")
	private ZonedDateTime expAt;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ZonedDateTime getExpAt() {
		return expAt;
	}

	public void setExpAt(ZonedDateTime expAt) {
		this.expAt = expAt;
	}
}
