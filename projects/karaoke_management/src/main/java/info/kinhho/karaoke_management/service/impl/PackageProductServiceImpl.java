package info.kinhho.karaoke_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.dtos.PackageProductDTO;
import info.kinhho.karaoke_management.entities.PackageProduct;
import info.kinhho.karaoke_management.repository.PackageProductRepository;
import info.kinhho.karaoke_management.service.PackageProductService;

@Service
public class PackageProductServiceImpl 
		extends BaseServiceImpl<PackageProduct, PackageProductDTO, PackageProductRepository>
		implements PackageProductService {

	public PackageProductServiceImpl() {}
	
	public PackageProductServiceImpl(PackageProductRepository repository) {
		super(repository);
	}

	public void createSeedData() { }

	@Override
	public List<PackageProductDTO> findAllByActive_DTO(boolean active) {

		return this.findAllByActive(active).stream().parallel().map(this::toDto).collect(Collectors.toList());
	}
	
	private PackageProductDTO toDto(PackageProduct entity) {
		
		ModelMapper modelMapper = new ModelMapper();
		PackageProductDTO dto = new PackageProductDTO();
		modelMapper.map(entity, dto);
		return dto;
	}
}
