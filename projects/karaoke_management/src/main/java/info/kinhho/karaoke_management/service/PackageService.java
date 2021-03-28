package info.kinhho.karaoke_management.service;

import java.util.List;

import info.kinhho.karaoke_management.dtos.PackageDTO;
import info.kinhho.karaoke_management.entities.Package;

public interface PackageService extends BaseService<Package> {

	public List<PackageDTO> findAll_DTO();
	public List<PackageDTO> findAllByActive_DTO(boolean active);
}
