package com.cjj.Pojo;

import lombok.Data;

@Data
public class Book {
  private Integer bookId;
  private String bookName;
  private String bookIsbn;
  private String bookPress;
  private String bookAuthor;
  private Integer bookPagination;
  private double bookPrice;
  private String bookUploadtime;
  private String bookStatus;
  private String bookBorrower;
  private String bookBorrowtime;
  private String bookReturntime;



}
