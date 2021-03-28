package info.kinhho.karaoke_management.service;

import java.util.List;

import info.kinhho.karaoke_management.dtos.SupplierDTO;
import info.kinhho.karaoke_management.entities.Supplier;

public interface SupplierService extends BaseService<Supplier> {
	
	public List<SupplierDTO> findAllByActive_DTO(boolean active);
}
