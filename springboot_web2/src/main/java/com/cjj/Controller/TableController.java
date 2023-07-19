package com.cjj.Controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjj.Mapper.BookUserplusMapper;
import com.cjj.Pojo.BookUser;
import com.cjj.Service.BookUserService;
import com.cjj.Service.BookUserplusService;
import com.cjj.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class TableController {
    @Autowired
    BookUserplusService bookUserService;

    @Autowired
    BookUserplusMapper bookUserplusMapper;
    /**
     *不带请求参数或者参数类型不对  400， Bad Request  一般都是浏览器参数没有正确传参
     * @param
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(/*@RequestParam ("a") int a*/){
       // int x=10/0;
        return "tables/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //表格内容的遍历
//       List<LoginUser> users= Arrays.asList(new LoginUser("zhangsan","123456"),
//                new LoginUser("lisi","111111"),
//                new LoginUser("hh","aaaaaa"),
//                new LoginUser("aa","aadd"));
//        model.addAttribute("users",users);

//        if (users.size()>3){
//            throw new UserTooManyException();
//        }

        //数据库use表的信息展示
        List<BookUser> list = bookUserService.list();

       // model.addAttribute("users",list);
        //分页查询参数
        Page<BookUser> page = new Page<BookUser>(pn, 2);
        //分页查询的结果
        Page<BookUser> userpage = bookUserService.page(page, null);
        //当前页
        long current = page.getCurrent();
        //当前页数
        long pages = page.getPages();
        //总记录数
        long total = page.getTotal();

        //查出数据库真正的数据，不在用html的users
        List<BookUser> records = page.getRecords();

        model.addAttribute("users",userpage);
        return "tables/dynamic_table";
    }

    /**
     * 删除用户信息
     * RedirectAttributes 重定向携带参数
     * @param id
     * @param pn
     * @param ra
     * @return
     */
    @GetMapping("/user/delete/{id}")
    public String DeleteUser(@PathVariable("id") Integer id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){

        bookUserService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "tables/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "tables/editable_table";
    }


    //访问增加页面
    @GetMapping("/insert_user")
    public String insert(){
        return "tables/insert_user";
    }

    //增加用户controller
    @PostMapping("/insertuser")
    public  String insertuser(@ModelAttribute BookUser bookUser) {
       int flag= bookUserplusMapper.insert(bookUser);
        log.info("表单提交的数据：{}",bookUser.toString());
        if (flag>=1) {
            log.info("添加数据成功");
        }
        else{
            log.info("添加数据失败");
        }
        return "redirect:/dynamic_table";
    }
    @Autowired
    BookUserService bookUserService2;
    //增加用户
    @ResponseBody
    @PostMapping("/addUser")
    public Result addUser(BookUser bookUser){
        try {
            bookUserService2.insertuser(bookUser);
            return new Result(true,"添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"添加失败");
        }
    }

}
