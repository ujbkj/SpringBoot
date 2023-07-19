package com.cjj.Controller;

import com.cjj.Mapper.BookUserplusMapper;
import com.cjj.Pojo.Book;
import com.cjj.Pojo.BookUser;
import com.cjj.Pojo.LoginUser;
import com.cjj.Service.BookService;
import com.cjj.Service.BookUserService;
import com.cjj.Service.BookUserplusService;
import com.cjj.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class IndexController {
    Logger logger=LoggerFactory.getLogger(IndexController.class);

    @Autowired
    StringRedisTemplate redisTemplate;
    /**
     * 数据库bookdb中user插入数据
     * 使用postman进行测试
     * @param bookUser
     * @return
     */
    @ResponseBody
    @PostMapping("/savauser")
    public BookUser savaBookuser(BookUser bookUser){
        bookUserService.insert(bookUser);
        return bookUser;
    }

    /**
     * 测试mybatis
     * 数据库User表
     * 根据id查询用户信息表
     */
    @Autowired
    BookUserService bookUserService;
    @GetMapping("/getBookUserId")
    @ResponseBody
    public BookUser getBookUserId(Integer id){
        return  bookUserService.getBookUserId(id);
    }

    /**
     * 修改用户信息
     * 根据用户id进行修改，
     */
    @Autowired
    BookUserplusService bookUserplusService;
    @PostMapping("/edituser")
    @ResponseBody
    public Result edituser(BookUser bookUser){
        try {
            bookUserplusService.updateById(bookUser);
            return new Result(true,"修改成功");

        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,"修改失败");
        }
    }

    /**
     * 测试mybatis
     * 数据库book表
     * @return
     */
    @Autowired
    BookService bookService;

    @ResponseBody
    @GetMapping("/book")
    public Book getBookId(@RequestParam("bookId") Integer bookId){

        return bookService.getBookId(bookId);
    }

    /**
     * 测试Druid的监控页的sql
     * @return
     */
    @Resource
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/sql")
    public String queryFrombookdb(){
        List<List> lists = jdbcTemplate.queryForList("select book_name from book", List.class);
        return lists.toString();
    }
    /**
     * 请求返回登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginpage()
    {
        return "login";
    }

    /**
     * 登录后来到main页面
     * @return
     */

    @PostMapping("/login")
    public String main(BookUser bookUser, HttpSession session, Model model) {
        try {
            BookUser buser=bookUserService.login(bookUser);

            if (buser!=null){
                //把登录成功的用户存起来
                session.setAttribute("bookUser",bookUser);
                //登录成功重定向前往index页面  防止表单重复提交
                //System.out.println("***************************"+session.getAttribute("bookUser"));
                log.info("登录成功：{}"+bookUser);
                return "redirect:/index.html";
            }
            else
                model.addAttribute("msg","账号或密码错误！");
            log.info("登录失败：{}"+bookUser);
            return "login";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("msg","系统异常！！！");
            return "login";
        }
    }

    /**
     * 每次刷新相当于重新提交一次表单(重新登录)，重新发送login请求，使
     * 用重定向方法解决，相当于第二次请求index
     * return “index” 重新加载index页面
     *
     * 拦截未登录的用户
     * @return
     */
    @GetMapping("/index.html")
    public String indexpage(HttpSession session,Model model){
        logger.info("当前方法是：{}","indexpage");
        //是否登录 拦截器 过滤器
//        Object loginUser=session.getAttribute("loginUser");
//        if(loginUser != null){
//            return "index";
//        }else
//            //回到登录界面
//            model.addAttribute("msg","请重新登录！");
//            return "login";
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String s=operations.get("/index.html");
        String s1=operations.get("/sql");
        model.addAttribute("maincount",s);
        model.addAttribute("sqlcount",s1);
        return "index";
    }

    /**
     * 通过请求方式退出到login页面
     * 清除掉session，点击logout退出登录
     * 返回到login页面
     * @return
     */
    @GetMapping("logout")
    public  String logout(HttpSession session, SessionStatus status, BookUser bookUser){
        System.out.println(session.getAttribute("bookUser"));
        session.invalidate();
        status.setComplete();
        System.out.println();
        logger.info("----------用户退出-------");
        return "redirect:/login";
    }


}
