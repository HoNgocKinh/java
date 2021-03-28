package info.kinhho.karaoke_management.dtos;

import java.time.ZonedDateTime;
import java.util.List;

public class PackageDTO extends BaseDTO {
	
	private String status;
	private ZonedDateTime expAt;
	private String packageCode;
	
	private SupplierDTO supplierDTO;
	
	private List<PackageProductDTO> packageProducts;
	
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
	public String getPackageCode() {
		return packageCode;
	}
	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}
	public SupplierDTO getSupplierDTO() {
		return supplierDTO;
	}
	public void setSupplierDTO(SupplierDTO supplierDTO) {
		this.supplierDTO = supplierDTO;
	}
}
