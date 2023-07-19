package com.cjj;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

/**
 * 所有测试都为不通过，如需测试通过，将方法内的值或者参数进行修改（值进行颠倒更换就能满足条件）
 * 断言测试，一条测试不成功，后续的测试都不会再进行测试
 * 如果需要测试报告，执行maven的clean+test
 */
@DisplayName("断言测试")
public class AssertionsTest {
    //简单断言
    @DisplayName("判断类型或对象是否相等")
    @Test
    void assertEquals(){
        int calc = 1+3;
        Assertions.assertEquals(4,calc,"两个值不相等");
        Assertions.assertNotEquals(5,calc,"两个值相等");
    }

    @DisplayName("判断类型或对象是否指向一样")
    @Test
    void assertSame(){
        Assertions.assertSame(new Object(),new Object(),"两个对象指向不一致");
        String i=new String();
        String j=i;
        Assertions.assertNotSame(i,j,"两个对象指向一致");
    }

    @DisplayName("判断给定的布尔值是否为 true/false")
    @Test
    void assertTrue(){
        int i=1;
        int j=2;
        Assertions.assertTrue(i==j,"i==j");
        Assertions.assertFalse(i!=j,"i!=j");
    }

    @DisplayName("判断给定的对象是否为 null")
    @Test
    void assertNull(){
        String n="你好";
       // Assertions.assertNull(n,"n不是为null");
        String l=null;
        Assertions.assertNotNull(l,"n为空");
    }
    //数组断言
    @DisplayName("判断数组断言的值是否相等")
    @Test
    void assertArrayEquals(){
        Assertions.assertArrayEquals(new int []{2,1},new int[]{1,2},"两个数组不相等");
    }

    //组合断言
    @DisplayName("组合断言")
    @Test
    void assertAll(){
        Assertions.assertAll("all",
                ()->Assertions.assertTrue(1==1,"1!=1"),
                ()->Assertions.assertSame(new Object(),new Object(),"两个对象指向不一致")
                );
    }

    //异常断言
    @DisplayName("异常断言")
    @Test
    void assertThrows(){
        //断定数学运算一定会异常
        ArithmeticException ArithmeticException = Assertions.assertThrows(
                ArithmeticException.class,()->{int i=10/2;},"数学运算异常居然正常运行？");
    }
    //超时断言
    @DisplayName("超时断言")
    @Test
    void assertTimeout(){
        Assertions.assertTimeout(Duration.ofMillis(1000),()->Thread.sleep(2000),"超过睡眠时间");
    }

    //快速失败
    @DisplayName("快速失败")
    @Test
    void fail (){
       Assertions.fail("fail方法测试失败");
    }

    //前置条件
    @DisplayName("前置条件")
    @Test
    void assumptions (){
        Assumptions.assumeTrue(false,"返回结果不是true");
        System.out.println("测试方法进行继续执行");
    }
}
