package info.kinhho.karaoke_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.dtos.PackageDTO;
import info.kinhho.karaoke_management.entities.Package;
import info.kinhho.karaoke_management.repository.PackageRepository;
import info.kinhho.karaoke_management.service.PackageService;

@Service
public class PackageServiceImpl 
		extends BaseServiceImpl<Package, PackageDTO, PackageRepository> 
		implements PackageService {

	public PackageServiceImpl(PackageRepository repository) {
		super(repository);
	}

	public void createSeedData() { }

	@Override
	public List<PackageDTO> findAll_DTO() {
		
		return this.findAll().stream().parallel().map(this::toDto).collect(Collectors.toList());
	}

	@Override
	public List<PackageDTO> findAllByActive_DTO(boolean active) {

		return this.findAllByActive(active).stream().parallel().map(this::toDto).collect(Collectors.toList());
	}
	
	private PackageDTO toDto(Package entity) {
		
		ModelMapper modelMapper = new ModelMapper();
		PackageDTO dto = new PackageDTO();
		modelMapper.map(entity, dto);
		return dto;
	}

}
