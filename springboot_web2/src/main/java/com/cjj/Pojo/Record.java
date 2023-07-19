package com.cjj.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Record {

  @TableId("record_id") //表明数据库主键
  private Integer recordId;

  private String recordBookname;
  private String recordBookisbn;
  private String recordBorrower;
  private String recordBorrowtime;
  private String recordRemandtime;

}
