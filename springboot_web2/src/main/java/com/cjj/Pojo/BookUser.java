package com.cjj.Pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class BookUser {
  //标注数据库id，id自增
  @TableId(value = "user_id",type = IdType.AUTO)
  private Integer userId;
  private String userName;
  private String userPassword;
  private String userEmail;
  private String userRole;
  private String userStatus;

}

