package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.dtos.PackageDTO;
import info.kinhho.karaoke_management.entities.Package;
import info.kinhho.karaoke_management.repository.PackageRepository;

@Service
public class PackageServiceImpl extends BaseServiceImpl<Package, PackageDTO, PackageRepository> {

	public PackageServiceImpl(PackageRepository repository) {
		super(repository);
	}

	public void createSeedData() {

	}

	@Override
	public PackageDTO toDto(Package e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Package toEntity(PackageDTO d) {
		// TODO Auto-generated method stub
		return null;
	}
}
