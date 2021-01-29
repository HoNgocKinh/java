package info.kinhho.swagger2.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class Resource1Controller {
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Xem danh sách User", response = String.class)
	public String test1(
			@ApiParam(value = "Đối tượng User cần tạo mới", type = "object", example = "abc123123") String abc,
			String abc1) {
		return "Test1 Resource!";
	}
}
