package tacos.config;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: swagger 配置类
 * @Author Jack Yang
 * @Date 2021/08/10 3:39 下午
 */

@Configuration  // 标明是配置类
@EnableSwagger2 //开启swagger功能
public class SwaggerConfig {

	 @Bean
	 public Docket createRestApi() {
		   // 指定扫描包路径
	        return new Docket(DocumentationType.SWAGGER_2)  // 指定生成的文档的类型是Swagger2
	             // .groupName("分布式任务系统") // 如果配置多个文档的时候，那么需要配置groupName来分组标识
	                .apiInfo(apiInfo()) // 用于生成API信息
	                .select() // select()函数返回一个ApiSelectorBuilder实例,用来控制接口被swagger做成文档
	                // 用于指定扫描哪个包下的接口
	                .apis(RequestHandlerSelectors.basePackage("tacos")) 
	                // 选择所有的API,如果你想只为部分API生成文档，可以配置这里
	                .paths(PathSelectors.any()) 
	               // .paths(PathSelectors.regex("/api/.*"))
	                .build();
	    }

	    /**
	     * 用于定义API主界面的信息，比如可以声明所有的API的总标题、描述、版本
	     * @return
	     */
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	        		// 设置标题
	                .title("XXXX服务") 
	                 // 描述
	                .description("XXXX服务应用接口API") 
	                 // 用于定义服务的域名
	                .termsOfServiceUrl("")
	                // 可以用来定义版本。
	                .version("Version: 1.0.1")                      
	                .build(); //
	    }
	    
}
