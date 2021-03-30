package info.kinhho.karaoke.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.kinhho.karaoke.entity.Food;
import info.kinhho.karaoke.entity.Producer;
import info.kinhho.karaoke.repository.ProducerRepository;


@Service
public class ProducerService {
	
	@Autowired
	private ProducerRepository producerRepository;
	
	public void createSeedData() {
		
		Producer producer1 = new Producer("Coca cola", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Producer producer2 = new Producer("Pepsi", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Producer producer3 = new Producer("Mirinda", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Producer producer4 = new Producer("Tân Hiệp Phát", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Producer producer5 = new Producer("Giải khát việt nam", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Producer producer6 = new Producer("Lavie", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
		Producer producer7 = new Producer("Red Bull", "01213551223", "1 Địa chỉ nào đó mà nó cũng dài dài như vầy nè");
			
		Food food1 = new Food("Food 1","Food", 20, "Cái", 20000);
		Food food2 = new Food("Food 2","Food", 20, "Cái", 20000);
		Food food3 = new Food("Food 3","Food", 20, "Cái", 20000);
		Food food4 = new Food("Food 4","Food", 20, "Cái", 20000);
		Food food5 = new Food("Food 5","Food", 20, "Cái", 20000);
		Food food6 = new Food("Food 6","Food", 20, "Cái", 20000);
		Food food7 = new Food("Food 7","Food", 20, "Cái", 20000);
		Food food8 = new Food("Food 8","Food", 20, "Cái", 20000);
		Food food9 = new Food("Food 9","Food", 20, "Cái", 20000);
		
		Food drink1 = new Food("Drink 1","Drink", 20, "Chai", 20000);
		Food drink2 = new Food("Drink 2","Drink", 20, "Chai", 20000);
		Food drink3 = new Food("Drink 3","Drink", 20, "Chai", 20000);
		Food drink4 = new Food("Drink 4","Drink", 20, "Chai", 20000);
		Food drink5 = new Food("Drink 5","Drink", 20, "Chai", 20000);
		Food drink6 = new Food("Drink 6","Drink", 20, "Chai", 20000);
		Food drink7 = new Food("Drink 7","Drink", 20, "Chai", 20000);
		Food drink8 = new Food("Drink 8","Drink", 20, "Chai", 20000);
		Food drink9 = new Food("Drink 9","Drink", 20, "Chai", 20000);
		
		Food food11 = new Food("Food 11","Food", 20, "Cái", 20000);
		Food food12 = new Food("Food 12","Food", 20, "Cái", 20000);
		Food food13 = new Food("Food 13","Food", 20, "Cái", 20000);
		Food food14 = new Food("Food 14","Food", 20, "Cái", 20000);
		Food food15 = new Food("Food 15","Food", 20, "Cái", 20000);
		Food food16 = new Food("Food 16","Food", 20, "Cái", 20000);
		Food food17 = new Food("Food 17","Food", 20, "Cái", 20000);
		Food food18 = new Food("Food 18","Food", 20, "Cái", 20000);
		Food food19 = new Food("Food 19","Food", 20, "Cái", 20000);
	 	
		Food drink11 = new Food("Drink 11","Drink", 20, "Chai", 20000);
		Food drink12 = new Food("Drink 12","Drink", 20, "Chai", 20000);
		Food drink13 = new Food("Drink 13","Drink", 20, "Chai", 20000);
		Food drink14 = new Food("Drink 14","Drink", 20, "Chai", 20000);
		Food drink15 = new Food("Drink 15","Drink", 20, "Chai", 20000);
		Food drink16 = new Food("Drink 16","Drink", 20, "Chai", 20000);
		Food drink17 = new Food("Drink 17","Drink", 20, "Chai", 20000);
		Food drink18 = new Food("Drink 18","Drink", 20, "Chai", 20000);
		Food drink19 = new Food("Drink 19","Drink", 20, "Chai", 20000);
		
		Food food21 = new Food("Food 21","Food", 20, "Cái", 20000);
		Food food22 = new Food("Food 22","Food", 20, "Cái", 20000);
		Food food23 = new Food("Food 23","Food", 20, "Cái", 20000);
		Food food24 = new Food("Food 24","Food", 20, "Cái", 20000);
		Food food25 = new Food("Food 25","Food", 20, "Cái", 20000);
		Food food26 = new Food("Food 26","Food", 20, "Cái", 20000);
		Food food27 = new Food("Food 27","Food", 20, "Cái", 20000);
		Food food28 = new Food("Food 28","Food", 20, "Cái", 20000);
		Food food29 = new Food("Food 29","Food", 20, "Cái", 20000);
		
		Food drink21 = new Food("Drink 21","Drink", 20, "Chai", 20000);
		Food drink22 = new Food("Drink 22","Drink", 20, "Chai", 20000);
		Food drink23 = new Food("Drink 23","Drink", 20, "Chai", 20000);
		Food drink24 = new Food("Drink 24","Drink", 20, "Chai", 20000);
		Food drink25 = new Food("Drink 25","Drink", 20, "Chai", 20000);
		Food drink26 = new Food("Drink 26","Drink", 20, "Chai", 20000);
		Food drink27 = new Food("Drink 27","Drink", 20, "Chai", 20000);
		Food drink28 = new Food("Drink 28","Drink", 20, "Chai", 20000);
		Food drink29 = new Food("Drink 29","Drink", 20, "Chai", 20000);
		
		Food food31 = new Food("Food 31","Food", 20, "Cái", 20000);
		Food food32 = new Food("Food 32","Food", 20, "Cái", 20000);
		Food food33 = new Food("Food 33","Food", 20, "Cái", 20000);
		Food food34 = new Food("Food 34","Food", 20, "Cái", 20000);
		Food food35 = new Food("Food 35","Food", 20, "Cái", 20000);
		Food food36 = new Food("Food 36","Food", 20, "Cái", 20000);
		Food food37 = new Food("Food 37","Food", 20, "Cái", 20000);
		Food food38 = new Food("Food 38","Food", 20, "Cái", 20000);
		Food food39 = new Food("Food 39","Food", 20, "Cái", 20000);
		
		Food drink31 = new Food("Drink 31","Drink", 20, "Chai", 20000);
		Food drink32 = new Food("Drink 32","Drink", 20, "Chai", 20000);
		Food drink33 = new Food("Drink 33","Drink", 20, "Chai", 20000);
		Food drink34 = new Food("Drink 34","Drink", 20, "Chai", 20000);
		Food drink35 = new Food("Drink 35","Drink", 20, "Chai", 20000);
		Food drink36 = new Food("Drink 36","Drink", 20, "Chai", 20000);
		Food drink37 = new Food("Drink 37","Drink", 20, "Chai", 20000);
		Food drink38 = new Food("Drink 38","Drink", 20, "Chai", 20000);
		Food drink39 = new Food("Drink 39","Drink", 20, "Chai", 20000);
		
		Food food41 = new Food("Food 41","Food", 20, "Cái", 20000);
		Food food42 = new Food("Food 42","Food", 20, "Cái", 20000);
		Food food43 = new Food("Food 43","Food", 20, "Cái", 20000);
		Food food44 = new Food("Food 44","Food", 20, "Cái", 20000);
		Food food45 = new Food("Food 45","Food", 20, "Cái", 20000);
		Food food46 = new Food("Food 46","Food", 20, "Cái", 20000);
		Food food47 = new Food("Food 47","Food", 20, "Cái", 20000);
		Food food48 = new Food("Food 48","Food", 20, "Cái", 20000);
		Food food49 = new Food("Food 49","Food", 20, "Cái", 20000);
	 	
		Food drink41 = new Food("Drink 41","Drink", 20, "Chai", 20000);
		Food drink42 = new Food("Drink 42","Drink", 20, "Chai", 20000);
		Food drink43 = new Food("Drink 43","Drink", 20, "Chai", 20000);
		Food drink44 = new Food("Drink 44","Drink", 20, "Chai", 20000);
		Food drink45 = new Food("Drink 45","Drink", 20, "Chai", 20000);
		Food drink46 = new Food("Drink 46","Drink", 20, "Chai", 20000);
		Food drink47 = new Food("Drink 47","Drink", 20, "Chai", 20000);
		Food drink48 = new Food("Drink 48","Drink", 20, "Chai", 20000);
		Food drink49 = new Food("Drink 49","Drink", 20, "Chai", 20000);
		
		Food food51 = new Food("Food 51","Food", 20, "Cái", 20000);
		Food food52 = new Food("Food 52","Food", 20, "Cái", 20000);
		Food food53 = new Food("Food 53","Food", 20, "Cái", 20000);
		Food food54 = new Food("Food 54","Food", 20, "Cái", 20000);
		Food food55 = new Food("Food 55","Food", 20, "Cái", 20000);
		Food food56 = new Food("Food 56","Food", 20, "Cái", 20000);
		Food food57 = new Food("Food 57","Food", 20, "Cái", 20000);
		Food food58 = new Food("Food 58","Food", 20, "Cái", 20000);
		Food food59 = new Food("Food 59","Food", 20, "Cái", 20000);
	
		Food drink51 = new Food("Drink 51","Drink", 20, "Chai", 20000);
		Food drink52 = new Food("Drink 52","Drink", 20, "Chai", 20000);
		Food drink53 = new Food("Drink 53","Drink", 20, "Chai", 20000);
		Food drink54 = new Food("Drink 54","Drink", 20, "Chai", 20000);
		Food drink55 = new Food("Drink 55","Drink", 20, "Chai", 20000);
		Food drink56 = new Food("Drink 56","Drink", 20, "Chai", 20000);
		Food drink57 = new Food("Drink 57","Drink", 20, "Chai", 20000);
		Food drink58 = new Food("Drink 58","Drink", 20, "Chai", 20000);
		Food drink59 = new Food("Drink 59","Drink", 20, "Chai", 20000);
	 	
		Food food61 = new Food("Food 61","Food", 20, "Cái", 20000);
		Food food62 = new Food("Food 62","Food", 20, "Cái", 20000);
		Food food63 = new Food("Food 63","Food", 20, "Cái", 20000);
		Food food64 = new Food("Food 64","Food", 20, "Cái", 20000);
		Food food65 = new Food("Food 65","Food", 20, "Cái", 20000);
		Food food66 = new Food("Food 66","Food", 20, "Cái", 20000);
		Food food67 = new Food("Food 67","Food", 20, "Cái", 20000);
		Food food68 = new Food("Food 68","Food", 20, "Cái", 20000);
		Food food69 = new Food("Food 69","Food", 20, "Cái", 20000);
		
		Food drink61 = new Food("Drink 61","Drink", 20, "Chai", 20000);
		Food drink62 = new Food("Drink 62","Drink", 20, "Chai", 20000);
		Food drink63 = new Food("Drink 63","Drink", 20, "Chai", 20000);
		Food drink64 = new Food("Drink 64","Drink", 20, "Chai", 20000);
		Food drink65 = new Food("Drink 65","Drink", 20, "Chai", 20000);
		Food drink66 = new Food("Drink 66","Drink", 20, "Chai", 20000);
		Food drink67 = new Food("Drink 67","Drink", 20, "Chai", 20000);
		Food drink68 = new Food("Drink 68","Drink", 20, "Chai", 20000);
		Food drink69 = new Food("Drink 69","Drink", 20, "Chai", 20000);
		
		List<Food> foods1 = new ArrayList<>();
		List<Food> foods2 = new ArrayList<>();
		List<Food> foods3 = new ArrayList<>();
		List<Food> foods4 = new ArrayList<>();
		List<Food> foods5 = new ArrayList<>();
		List<Food> foods6 = new ArrayList<>();
		List<Food> foods7 = new ArrayList<>();
		
		Collections.addAll(foods1, food1,  food2,  food3,  food4,  food5,  food6,  food7,  food8,  food9,  drink1,  drink2,  drink3,  drink4,  drink5,  drink6,  drink7,  drink8,  drink9);
		Collections.addAll(foods2, food11, food12, food13, food14, food15, food16, food17, food18, food19, drink11, drink12, drink13, drink14, drink15, drink16, drink17, drink18, drink19);
		Collections.addAll(foods3, food21, food22, food23, food24, food25, food26, food27, food28, food29, drink21, drink22, drink23, drink24, drink25, drink26, drink27, drink28, drink29);
		Collections.addAll(foods4, food31, food32, food33, food34, food35, food36, food37, food38, food39, drink31, drink32, drink33, drink34, drink35, drink36, drink37, drink38, drink39);
		Collections.addAll(foods5, food41, food42, food43, food44, food45, food46, food47, food48, food49, drink41, drink42, drink43, drink44, drink45, drink46, drink47, drink48, drink49);
		Collections.addAll(foods6, food51, food52, food53, food54, food55, food56, food57, food58, food59, drink51, drink52, drink53, drink54, drink55, drink56, drink57, drink58, drink59);
		Collections.addAll(foods7, food61, food62, food63, food64, food65, food66, food67, food68, food69, drink61, drink62, drink63, drink64, drink65, drink66, drink67, drink68, drink69);
		
		producer1.setFoods(foods1);
		producer2.setFoods(foods2);
		producer3.setFoods(foods3);
		producer4.setFoods(foods4);
		producer5.setFoods(foods5);
		producer6.setFoods(foods6);
		producer7.setFoods(foods7);
		
		producerRepository.save(producer1);
		producerRepository.save(producer2);
		producerRepository.save(producer3);
		producerRepository.save(producer4);
		producerRepository.save(producer5);
		producerRepository.save(producer6);
		producerRepository.save(producer7);
		
	}

	public Iterable<Producer> get() {
		
		return producerRepository.findAll();
	}
	
	public Producer get(String id) {
		
		return producerRepository.findById(Integer.parseInt(id)).get();
	}
	public void save(Producer producer) {
		this.producerRepository.save(producer);
	}
	
	public void update(Producer producer) {
		this.producerRepository.deleteById(producer.getId());
		this.producerRepository.save(producer);
	}
	
	public void delete(String id) {
		this.producerRepository.deleteById(Integer.parseInt(id));
	}
}
