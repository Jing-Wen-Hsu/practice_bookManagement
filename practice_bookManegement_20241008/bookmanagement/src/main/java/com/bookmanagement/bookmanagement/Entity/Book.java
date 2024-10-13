package com.bookmanagement.bookmanagement.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Book的資料表欄位有:id、name(書名)、page(頁數)
//註解為Entity層
//註解@Id表示為主鍵
//註解@GeneratedValue ... 表示為自增長(在資料庫添加AUTO_INCREMENT)

//建構式
//getter、setter

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int page;

    public Book() {
    }

    public Book(Long id, String name, int page) {
        this.id = id;
        this.name = name;
        this.page = page;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
