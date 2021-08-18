package tacos.controller;

import tacos.config;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.impl.DefaultKaptcha;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tacos.util.Util;

@Controller
@Api(tags = "验证码图") //  tags：你可以当作是这个组的名字。
@RequestMapping("api")
public class CaptchaController {
 
	@Resource
    private DefaultKaptcha captchaProducer;
    /**
     * 登录验证码SessionKey
     */
    public static final String LOGIN_VALIDATE_CODE = "login_validate_code";
    /**
     * 登录验证码图片
     */
    @GetMapping("/loginValidateCode")
    @ApiOperation(value="loginValidateCode方法", notes="loginValidateCode Swagger测试方法--loginValidateCode")
    public void loginValidateCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Util.validateCode(request,response,captchaProducer,LOGIN_VALIDATE_CODE);
    }
 
    /**
     * 检查验证码是否正确
     */
    @GetMapping("/checkLoginValidateCode")
    @ApiOperation(value="checkLoginValidateCode方法", notes="checkLoginValidateCode Swagger测试方法--checkLoginValidateCode")
    @ResponseBody
    public HashMap checkLoginValidateCode(HttpServletRequest request,@RequestParam("validateCode")String validateCode) {
        String loginValidateCode = request.getSession().getAttribute(LOGIN_VALIDATE_CODE).toString();
        HashMap<String,Object> map = new HashMap<String,Object>();
        if(loginValidateCode == null){
            map.put("status",null);//验证码过期
        }else if(loginValidateCode.equals(validateCode)){
            map.put("status",true);//验证码正确
        }else if(!loginValidateCode.equals(validateCode)){
            map.put("status",false);//验证码不正确
        }
        map.put("code",200);
        return map;
    }
}
