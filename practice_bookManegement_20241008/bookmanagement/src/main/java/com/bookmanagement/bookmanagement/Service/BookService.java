package com.bookmanagement.bookmanagement.Service;


import com.bookmanagement.bookmanagement.Entity.Book;
import com.bookmanagement.bookmanagement.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//註解為@Service層

//邏輯(服務層)要透過介面去操作，因此注入BookRepository(資料存取層)進行資料提取

@Service
public class BookService {
    private final BookRepository bookRepository;
    //建構式
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //新增書籍
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    //查詢所有書籍
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //透過id查詢指定書籍，允許空值optional...
    public Book getBookById (Long id) {
//        return bookRepository.findById(id);
        Optional<Book> opt = bookRepository.findById(id);
        return opt.orElse(null);
    }

    //根據指定id修改書籍
        //Book book：傳入的書籍對象，包含了需要更新的書籍資訊。 updateBook 要被更新的對象(原書籍資料)
    public Book updateBookById(Book book) {
        Optional<Book> opt = bookRepository.findById(book.getId()); //先找到這本書
        if (opt.isPresent()){                                          //如果這本書存在
            Book updateBook = opt.get();                                 //取出這本書(updateBook)
            updateBook.setName((book.getName() == null ? updateBook.getName():book.getName())); //set書名 ->判斷 傳進來的新書籍資料是否有名字，null表示沒有=不用更新書名，所以get原書名就可以了，有的畫GET新書名。
            updateBook.setPage((book.getPage()));                           //直接set頁數 ，型別是int 不會有空值，所以直接SET
            return bookRepository.save(updateBook); //儲存新資料
        }
        return  null; //如果查詢到的書籍不存在，則返回 null
    }

    //根據指定id刪除書籍資料
    public void deleteBookById (Long id) {
        Optional<Book> opt = bookRepository.findById(id);
        opt.ifPresent(book -> bookRepository.deleteById(book.getId()));
    }

}
