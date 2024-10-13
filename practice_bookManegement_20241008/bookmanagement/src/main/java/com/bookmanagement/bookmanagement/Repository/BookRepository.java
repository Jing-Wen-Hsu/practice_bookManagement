package com.bookmanagement.bookmanagement.Repository;

import com.bookmanagement.bookmanagement.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//註解為@Repository層
//class改為interface，並繼承JpaRepository
//<Book,Long> Book->entity  Long->主鍵型別

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
