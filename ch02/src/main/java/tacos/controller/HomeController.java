package tacos.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(tags = "主页") //  tags：你可以当作是这个组的名字。
public class HomeController {
  @GetMapping("/")
  public String home() {
	  return "home";
  }
}
