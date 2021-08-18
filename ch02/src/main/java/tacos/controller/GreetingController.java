package tacos.controller;



import java.util.concurrent.atomic.AtomicLong;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tacos.Greeting;
import tacos.util.Util;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试swagger controller
 * @Author JackYang
 * @Date 2021/08/10 2:59 下午
*/

@RestController
@Api(tags = "致意") //  tags：你可以当作是这个组的名字。
@RequestMapping("api")
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private final Util uuid = new Util();
	
	@GetMapping("/greeting")
	@ApiOperation(value="greeting 方法", notes="greeting Swagger测试方法--greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		 //System.out.println("Hello" + " " + name);
		 return new Greeting(counter.incrementAndGet(), uuid.getUUID(), String.format(template, name));
		
	}
}
