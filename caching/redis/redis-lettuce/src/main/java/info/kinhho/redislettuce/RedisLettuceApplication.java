package info.kinhho.redislettuce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisLettuceApplication implements CommandLineRunner {

	@Autowired
	private RedisTemplate<Object, Object> template;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		template.opsForValue().set("Name", "Kinh");
		// In ra màn hình Giá trị của key "loda" trong Redis
        System.out.println("Value of key loda: " + template.opsForValue().get("Name"));
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisLettuceApplication.class, args);
	}
}
