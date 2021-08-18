package tacos.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import tacos.User;
import tacos.util.Util;

/**
 * @Description: User controller
 * @Author JackYang
 * @Date 2021/08/11 9:259 上午
*/

@RestController
@Api(tags = "用户") //  tags：你可以当作是这个组的名字。
@RequestMapping("api")
public class UserController {
	
	private final Util uuid = new Util();
	
	@PostMapping("/user")
	@ApiOperation(value="新增用户", notes="保存新增的用户信息")	
	public User saveUser(@RequestBody User user) {
		 user.setUserId(uuid.getUUID());
		 return user;
	}
	
	
	@DeleteMapping("/user/{userId}")
	@ApiOperation(value="删除user", notes="删除更新的user信息")
	public User deleteUser(@PathVariable String userId) {
		// User user =  userService.getById(userId);
		//  userService.updateUser(user);
		 return userId;
	}
	
	@PutMapping("/user/{userId}")
	@ApiOperation(value="更新user", notes="保存更新的user信息")
	public User updateUser(@PathVariable String userId, @RequestBody User user) {
		 user.setUserId(userId);
		// System.out.println("Hello" + " " + name);
		 return user;
	}
	
	@GetMapping("/user/{userId}")
	@ApiOperation(value="获取user", notes="获取user信息")
	public User getUser(@PathVariable String userId) {
		// User user =  userService.getById(userId);
		// System.out.println("Hello" + " " + name);
		 return userId;
	}
}
