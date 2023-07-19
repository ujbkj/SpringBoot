package com.caijunjie.springboot_web.controller;
import com.caijunjie.springboot_web.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Parametercontroller {
    /**
     * 数据绑定：页面提交的请求数据（get、post)都可以和对象属性绑定
     * @param person
     * @return
     */
    @PostMapping("/saveuser")
    public Person saveuser(Person person){
        return person;
    }
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String ,Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String,String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader  Map<String,String>header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String,String> parame
                               ) {
        Map<String,Object> map=new HashMap<>();
//        map.put("id",id);
//        map.put("username",name);
//        map.put("pv",pv);

//        map.put("User-Agent",userAgent);
//        map.put("header",header);

        map.put("age",age);
        map.put("inters",inters);
        map.put("parame",parame);

//        map.put("Cookie",Cookie);
        return map;
    }


    @PostMapping(value = "/save")
    public  Map psotMethod(@RequestBody String content) {
        Map<String,Object> map=new HashMap<>();
        try {
            map.put("content", URLDecoder.decode(content,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            System.out.println( URLDecoder.decode(content,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }

//    1.语法: /cars/sell;low=34;brank=byd,auti,yd
//    2.springboot默认禁用了矩阵变量的功能
//    手动开启：原理；对于路径的变量，urlpathhelper进行解析，r
//                              emoversemicoloncontent(移除分号内容)支持矩阵变量
//    3.矩阵变量必须有URL路径变量才能解析
    @GetMapping("cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map=new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        System.out.println("路径--------"+path);
        return map;
    }
//    /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public  Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                     @MatrixVariable(value = "age",pathVar ="empId")Integer empAge){
        Map<String,Object> map=new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }
}
