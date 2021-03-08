package info.kinhho.karaoke.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import info.kinhho.karaoke.entity.Product;
import info.kinhho.karaoke.entity.Supplier;
import info.kinhho.karaoke.repository.SupplierRepository;


@Service
public class SupplierService extends BaseService<Supplier, SupplierRepository> {
	
	public void createSeedData() {
		
		Supplier producer1 = new Supplier("Coca cola", "01213551223", "Atlanta, Georgia, United States");
		Supplier producer2 = new Supplier("Pepsi", "01213551223", "Purchase, Harrison, New York, United States");
		Supplier producer3 = new Supplier("Mirinda", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Supplier producer4 = new Supplier("Tân Hiệp Phát", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Supplier producer5 = new Supplier("Giải khát việt nam", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Supplier producer6 = new Supplier("Lavie", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Supplier producer7 = new Supplier("Red Bull", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
			
		Product food1 = new Product("Product 1","Product", 20, "Cái", 20000);
		Product food2 = new Product("Product 2","Product", 20, "Cái", 20000);
		Product food3 = new Product("Product 3","Product", 20, "Cái", 20000);
		Product food4 = new Product("Product 4","Product", 20, "Cái", 20000);
		Product food5 = new Product("Product 5","Product", 20, "Cái", 20000);
		Product food6 = new Product("Product 6","Product", 20, "Cái", 20000);
		Product food7 = new Product("Product 7","Product", 20, "Cái", 20000);
		Product food8 = new Product("Product 8","Product", 20, "Cái", 20000);
		Product food9 = new Product("Product 9","Product", 20, "Cái", 20000);
		
		Product drink1 = new Product("Drink 1","Drink", 20, "Chai", 20000);
		Product drink2 = new Product("Drink 2","Drink", 20, "Chai", 20000);
		Product drink3 = new Product("Drink 3","Drink", 20, "Chai", 20000);
		Product drink4 = new Product("Drink 4","Drink", 20, "Chai", 20000);
		Product drink5 = new Product("Drink 5","Drink", 20, "Chai", 20000);
		Product drink6 = new Product("Drink 6","Drink", 20, "Chai", 20000);
		Product drink7 = new Product("Drink 7","Drink", 20, "Chai", 20000);
		Product drink8 = new Product("Drink 8","Drink", 20, "Chai", 20000);
		Product drink9 = new Product("Drink 9","Drink", 20, "Chai", 20000);
		
		Product food11 = new Product("Product 11","Product", 20, "Cái", 20000);
		Product food12 = new Product("Product 12","Product", 20, "Cái", 20000);
		Product food13 = new Product("Product 13","Product", 20, "Cái", 20000);
		Product food14 = new Product("Product 14","Product", 20, "Cái", 20000);
		Product food15 = new Product("Product 15","Product", 20, "Cái", 20000);
		Product food16 = new Product("Product 16","Product", 20, "Cái", 20000);
		Product food17 = new Product("Product 17","Product", 20, "Cái", 20000);
		Product food18 = new Product("Product 18","Product", 20, "Cái", 20000);
		Product food19 = new Product("Product 19","Product", 20, "Cái", 20000);
	 	
		Product drink11 = new Product("Drink 11","Drink", 20, "Chai", 20000);
		Product drink12 = new Product("Drink 12","Drink", 20, "Chai", 20000);
		Product drink13 = new Product("Drink 13","Drink", 20, "Chai", 20000);
		Product drink14 = new Product("Drink 14","Drink", 20, "Chai", 20000);
		Product drink15 = new Product("Drink 15","Drink", 20, "Chai", 20000);
		Product drink16 = new Product("Drink 16","Drink", 20, "Chai", 20000);
		Product drink17 = new Product("Drink 17","Drink", 20, "Chai", 20000);
		Product drink18 = new Product("Drink 18","Drink", 20, "Chai", 20000);
		Product drink19 = new Product("Drink 19","Drink", 20, "Chai", 20000);
		
		Product food21 = new Product("Product 21","Product", 20, "Cái", 20000);
		Product food22 = new Product("Product 22","Product", 20, "Cái", 20000);
		Product food23 = new Product("Product 23","Product", 20, "Cái", 20000);
		Product food24 = new Product("Product 24","Product", 20, "Cái", 20000);
		Product food25 = new Product("Product 25","Product", 20, "Cái", 20000);
		Product food26 = new Product("Product 26","Product", 20, "Cái", 20000);
		Product food27 = new Product("Product 27","Product", 20, "Cái", 20000);
		Product food28 = new Product("Product 28","Product", 20, "Cái", 20000);
		Product food29 = new Product("Product 29","Product", 20, "Cái", 20000);
		
		Product drink21 = new Product("Drink 21","Drink", 20, "Chai", 20000);
		Product drink22 = new Product("Drink 22","Drink", 20, "Chai", 20000);
		Product drink23 = new Product("Drink 23","Drink", 20, "Chai", 20000);
		Product drink24 = new Product("Drink 24","Drink", 20, "Chai", 20000);
		Product drink25 = new Product("Drink 25","Drink", 20, "Chai", 20000);
		Product drink26 = new Product("Drink 26","Drink", 20, "Chai", 20000);
		Product drink27 = new Product("Drink 27","Drink", 20, "Chai", 20000);
		Product drink28 = new Product("Drink 28","Drink", 20, "Chai", 20000);
		Product drink29 = new Product("Drink 29","Drink", 20, "Chai", 20000);
		
		Product food31 = new Product("Product 31","Product", 20, "Cái", 20000);
		Product food32 = new Product("Product 32","Product", 20, "Cái", 20000);
		Product food33 = new Product("Product 33","Product", 20, "Cái", 20000);
		Product food34 = new Product("Product 34","Product", 20, "Cái", 20000);
		Product food35 = new Product("Product 35","Product", 20, "Cái", 20000);
		Product food36 = new Product("Product 36","Product", 20, "Cái", 20000);
		Product food37 = new Product("Product 37","Product", 20, "Cái", 20000);
		Product food38 = new Product("Product 38","Product", 20, "Cái", 20000);
		Product food39 = new Product("Product 39","Product", 20, "Cái", 20000);
		
		Product drink31 = new Product("Drink 31","Drink", 20, "Chai", 20000);
		Product drink32 = new Product("Drink 32","Drink", 20, "Chai", 20000);
		Product drink33 = new Product("Drink 33","Drink", 20, "Chai", 20000);
		Product drink34 = new Product("Drink 34","Drink", 20, "Chai", 20000);
		Product drink35 = new Product("Drink 35","Drink", 20, "Chai", 20000);
		Product drink36 = new Product("Drink 36","Drink", 20, "Chai", 20000);
		Product drink37 = new Product("Drink 37","Drink", 20, "Chai", 20000);
		Product drink38 = new Product("Drink 38","Drink", 20, "Chai", 20000);
		Product drink39 = new Product("Drink 39","Drink", 20, "Chai", 20000);
		
		Product food41 = new Product("Product 41","Product", 20, "Cái", 20000);
		Product food42 = new Product("Product 42","Product", 20, "Cái", 20000);
		Product food43 = new Product("Product 43","Product", 20, "Cái", 20000);
		Product food44 = new Product("Product 44","Product", 20, "Cái", 20000);
		Product food45 = new Product("Product 45","Product", 20, "Cái", 20000);
		Product food46 = new Product("Product 46","Product", 20, "Cái", 20000);
		Product food47 = new Product("Product 47","Product", 20, "Cái", 20000);
		Product food48 = new Product("Product 48","Product", 20, "Cái", 20000);
		Product food49 = new Product("Product 49","Product", 20, "Cái", 20000);
	 	
		Product drink41 = new Product("Drink 41","Drink", 20, "Chai", 20000);
		Product drink42 = new Product("Drink 42","Drink", 20, "Chai", 20000);
		Product drink43 = new Product("Drink 43","Drink", 20, "Chai", 20000);
		Product drink44 = new Product("Drink 44","Drink", 20, "Chai", 20000);
		Product drink45 = new Product("Drink 45","Drink", 20, "Chai", 20000);
		Product drink46 = new Product("Drink 46","Drink", 20, "Chai", 20000);
		Product drink47 = new Product("Drink 47","Drink", 20, "Chai", 20000);
		Product drink48 = new Product("Drink 48","Drink", 20, "Chai", 20000);
		Product drink49 = new Product("Drink 49","Drink", 20, "Chai", 20000);
		
		Product food51 = new Product("Product 51","Product", 20, "Cái", 20000);
		Product food52 = new Product("Product 52","Product", 20, "Cái", 20000);
		Product food53 = new Product("Product 53","Product", 20, "Cái", 20000);
		Product food54 = new Product("Product 54","Product", 20, "Cái", 20000);
		Product food55 = new Product("Product 55","Product", 20, "Cái", 20000);
		Product food56 = new Product("Product 56","Product", 20, "Cái", 20000);
		Product food57 = new Product("Product 57","Product", 20, "Cái", 20000);
		Product food58 = new Product("Product 58","Product", 20, "Cái", 20000);
		Product food59 = new Product("Product 59","Product", 20, "Cái", 20000);
	
		Product drink51 = new Product("Drink 51","Drink", 20, "Chai", 20000);
		Product drink52 = new Product("Drink 52","Drink", 20, "Chai", 20000);
		Product drink53 = new Product("Drink 53","Drink", 20, "Chai", 20000);
		Product drink54 = new Product("Drink 54","Drink", 20, "Chai", 20000);
		Product drink55 = new Product("Drink 55","Drink", 20, "Chai", 20000);
		Product drink56 = new Product("Drink 56","Drink", 20, "Chai", 20000);
		Product drink57 = new Product("Drink 57","Drink", 20, "Chai", 20000);
		Product drink58 = new Product("Drink 58","Drink", 20, "Chai", 20000);
		Product drink59 = new Product("Drink 59","Drink", 20, "Chai", 20000);
	 	
		Product food61 = new Product("Product 61","Product", 20, "Cái", 20000);
		Product food62 = new Product("Product 62","Product", 20, "Cái", 20000);
		Product food63 = new Product("Product 63","Product", 20, "Cái", 20000);
		Product food64 = new Product("Product 64","Product", 20, "Cái", 20000);
		Product food65 = new Product("Product 65","Product", 20, "Cái", 20000);
		Product food66 = new Product("Product 66","Product", 20, "Cái", 20000);
		Product food67 = new Product("Product 67","Product", 20, "Cái", 20000);
		Product food68 = new Product("Product 68","Product", 20, "Cái", 20000);
		Product food69 = new Product("Product 69","Product", 20, "Cái", 20000);
		
		Product drink61 = new Product("Drink 61","Drink", 20, "Chai", 20000);
		Product drink62 = new Product("Drink 62","Drink", 20, "Chai", 20000);
		Product drink63 = new Product("Drink 63","Drink", 20, "Chai", 20000);
		Product drink64 = new Product("Drink 64","Drink", 20, "Chai", 20000);
		Product drink65 = new Product("Drink 65","Drink", 20, "Chai", 20000);
		Product drink66 = new Product("Drink 66","Drink", 20, "Chai", 20000);
		Product drink67 = new Product("Drink 67","Drink", 20, "Chai", 20000);
		Product drink68 = new Product("Drink 68","Drink", 20, "Chai", 20000);
		Product drink69 = new Product("Drink 69","Drink", 20, "Chai", 20000);
		
		List<Product> foods1 = new ArrayList<>();
		List<Product> foods2 = new ArrayList<>();
		List<Product> foods3 = new ArrayList<>();
		List<Product> foods4 = new ArrayList<>();
		List<Product> foods5 = new ArrayList<>();
		List<Product> foods6 = new ArrayList<>();
		List<Product> foods7 = new ArrayList<>();
		
		Collections.addAll(foods1, food1,  food2,  food3,  food4,  food5,  food6,  food7,  food8,  food9,  drink1,  drink2,  drink3,  drink4,  drink5,  drink6,  drink7,  drink8,  drink9);
		Collections.addAll(foods2, food11, food12, food13, food14, food15, food16, food17, food18, food19, drink11, drink12, drink13, drink14, drink15, drink16, drink17, drink18, drink19);
		Collections.addAll(foods3, food21, food22, food23, food24, food25, food26, food27, food28, food29, drink21, drink22, drink23, drink24, drink25, drink26, drink27, drink28, drink29);
		Collections.addAll(foods4, food31, food32, food33, food34, food35, food36, food37, food38, food39, drink31, drink32, drink33, drink34, drink35, drink36, drink37, drink38, drink39);
		Collections.addAll(foods5, food41, food42, food43, food44, food45, food46, food47, food48, food49, drink41, drink42, drink43, drink44, drink45, drink46, drink47, drink48, drink49);
		Collections.addAll(foods6, food51, food52, food53, food54, food55, food56, food57, food58, food59, drink51, drink52, drink53, drink54, drink55, drink56, drink57, drink58, drink59);
		Collections.addAll(foods7, food61, food62, food63, food64, food65, food66, food67, food68, food69, drink61, drink62, drink63, drink64, drink65, drink66, drink67, drink68, drink69);
		
//		producer1.setProducts(foods1);
//		producer2.setProducts(foods2);
//		producer3.setProducts(foods3);
//		producer4.setProducts(foods4);
//		producer5.setProducts(foods5);
//		producer6.setProducts(foods6);
//		producer7.setProducts(foods7);
//		
//		producerRepository.save(producer1);
//		producerRepository.save(producer2);
//		producerRepository.save(producer3);
//		producerRepository.save(producer4);
//		producerRepository.save(producer5);
//		producerRepository.save(producer6);
//		producerRepository.save(producer7);
		
	}
}
