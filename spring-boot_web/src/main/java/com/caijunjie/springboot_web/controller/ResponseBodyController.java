package com.caijunjie.springboot_web.controller;
import com.caijunjie.springboot_web.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
@Slf4j
@Controller
public class ResponseBodyController {
   Logger logger= LoggerFactory.getLogger(ResponseBodyController.class);
//   @ResponseBody //RequestResponseBodyMethodProcessor-->MessageConverter
//   @GetMapping("/file")
//   public FileSystemResource file(){
//      //文件以这样的方式返回看是谁处理的（messageConverter）
//      return null;
//   }

    /**
     * 1.浏览器发送请求  [application/xml]--> jacksonxmlConverter
     * 2.ajax请求返回json [application/json]-->jacksonjsonConverter
     * xxxapp发请求，返回自定义协议数据 [application/caijunjie] --?xxxConverter
     *          属性值1;属性值2 //以分号隔开
     *
     * 步骤：
     * 1.添加自定义的MessageConverter进系统底层
     * 2.系统底层就会统计出所有的MessageConverter能操作哪些类型
     * 3.客户端内容协商[caijunjie -->caijunjie]
     *
     *
     * 如何以参数url形成进行自定义的内容协商
      * @return
     */
    @ResponseBody //利用返回值处理器里面的消息转换器进行处理
    @GetMapping(value = "test/person")
    public Person goperson(){
      Person person1=new Person();
        person1.setAge(18);
        person1.setBirth(new Date());
        person1.setUserName("zhangsan");
        logger.info("-------执行goperson()---------");
        return person1;
    }
}
