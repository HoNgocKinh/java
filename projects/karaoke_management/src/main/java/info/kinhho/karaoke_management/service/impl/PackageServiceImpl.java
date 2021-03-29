package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.Package;
import info.kinhho.karaoke_management.repository.PackageRepository;
import info.kinhho.karaoke_management.service.PackageService;

@Service
public class PackageServiceImpl 
		extends BaseServiceImpl<Package, PackageRepository> 
		implements PackageService {

	public PackageServiceImpl(PackageRepository repository) {
		super(repository);
	}

	public void createSeedData() { }
}
