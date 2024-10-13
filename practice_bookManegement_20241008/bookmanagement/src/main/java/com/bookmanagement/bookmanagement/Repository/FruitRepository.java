package com.bookmanagement.bookmanagement.Repository;

import com.bookmanagement.bookmanagement.Entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository <Fruit,Long> {

}
