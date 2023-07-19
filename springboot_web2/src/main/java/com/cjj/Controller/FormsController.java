package com.cjj.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试
 * 跳转到form_layouts页面
 */
@Slf4j
@Controller
public class FormsController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
       //log.info("执行方法{}","form_layouts");
        return "form/form_layouts";
    }

    /**
     * 处理文件上传请求
     * MultipartFile自动封装上传的文件
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息,email={},username={},headerImg={},photos={}",email, username,headerImg.getSize() ,photos.length);
        if(!headerImg.isEmpty()){
            //保存到文件服务器，oss服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("F:\\H5\\"+originalFilename));
        }

        if (photos.length>0){
            for (MultipartFile photo:photos){
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("F:\\H5\\"+originalFilename));
                }
            }
        }
        return "index";
    }
}
