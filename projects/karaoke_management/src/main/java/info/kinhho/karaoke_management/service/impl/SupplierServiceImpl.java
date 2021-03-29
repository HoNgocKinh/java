package info.kinhho.karaoke_management.service.impl;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke_management.entities.Supplier;
import info.kinhho.karaoke_management.repository.SupplierRepository;
import info.kinhho.karaoke_management.service.SupplierService;

@Service
public class SupplierServiceImpl 
		extends BaseServiceImpl<Supplier, SupplierRepository> 
		implements SupplierService {

	public SupplierServiceImpl() {}
	
	public SupplierServiceImpl(SupplierRepository repository) {
		super(repository);
	}

	public void createSeedData() {
		Supplier supplier1 = new Supplier("Coca cola", "01213551223", "Atlanta, Georgia, United States");
		Supplier supplier2 = new Supplier("Pepsi", "01213551223", "Purchase, Harrison, New York, United States");
		Supplier supplier3 = new Supplier("Mirinda", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Supplier supplier4 = new Supplier("Tân Hiệp Phát", "01213551223", "219 Đại lộ Bình Dương, Vĩnh Phú, Thuận An, Bình Dương");
		Supplier supplier5 = new Supplier("Công Ty Tnhh Dv Thực Phẩm & Giải Khát Việt Nam", "01213551223", "91 Pasteur, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh");
		Supplier supplier6 = new Supplier("Lavie", "01213551223", "Way 1A, Tường Khánh Block, Ward Khánh Hậu, Tân An City, Long An Province");
		
		repository.save(supplier1);
		repository.save(supplier2);
		repository.save(supplier3);
		repository.save(supplier4);
		repository.save(supplier5);
		repository.save(supplier6);
	}
}