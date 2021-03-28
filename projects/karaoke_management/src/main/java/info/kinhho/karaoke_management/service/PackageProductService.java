package info.kinhho.karaoke_management.service;

import java.util.List;

import info.kinhho.karaoke_management.dtos.PackageProductDTO;
import info.kinhho.karaoke_management.entities.PackageProduct;

public interface PackageProductService extends BaseService<PackageProduct> {

	public List<PackageProductDTO> findAllByActive_DTO(boolean active);
}
