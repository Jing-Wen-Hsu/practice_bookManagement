package com.bookmanagement.bookmanagement.Controller;


import com.bookmanagement.bookmanagement.Entity.Book;
import com.bookmanagement.bookmanagement.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//註解為@RestControlle層
//@RestController 是 @Controller 和 @ResponseBody 的組合。它專門用於處理 RESTful Web 服務。
//@RequestMapping("/api/book") 設定BookController中的所有網址的開頭都是/api/book
//注入service層，建構式

@RestController
@RequestMapping("/api/book")  //所有請求的路徑開頭都是/api/book
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //新增 ， 並將新增的book資訊回傳
    @PostMapping("/")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book),HttpStatus.CREATED);
    }

    //查詢所有書籍，並回傳
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    //查詢指定書籍，並回傳
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    //修改指定書籍的內容
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById (@PathVariable("id") Long id , @RequestBody Book book) {
    book.setId(id);
    return ResponseEntity.ok(bookService.updateBookById(book));
    }

    //刪除指定書籍
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById (@PathVariable("id")Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
