package com.bookmanagement.bookmanagement.Repository;


import com.bookmanagement.bookmanagement.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {

}
