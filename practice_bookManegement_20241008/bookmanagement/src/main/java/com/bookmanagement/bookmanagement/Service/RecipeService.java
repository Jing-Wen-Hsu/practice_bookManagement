package com.bookmanagement.bookmanagement.Service;


import com.bookmanagement.bookmanagement.Entity.Book;
import com.bookmanagement.bookmanagement.Entity.Recipe;
import com.bookmanagement.bookmanagement.Repository.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    //新增食譜
    public Recipe addRecipe (Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    //查詢所有食譜
    public List<Recipe> getAllRecipes (){
        return recipeRepository.findAll();
    }

    //查詢指定id食譜 ->要判斷id存不存在
    public Recipe getRecipeById (Long id){
        Optional<Recipe> opt = recipeRepository.findById(id);
        return opt.orElse(null);
    }

    //修改食譜
    public Recipe updateRecipeById (Recipe recipe){   //Recipe recipe是傳進來的新資料
    Optional<Recipe> opt = recipeRepository.findById(recipe.getId());
    if (opt.isPresent()) { //如果這個id的食譜存在
        Recipe updatedRecipe =  opt.get();                  //取出舊的食譜資料
        updatedRecipe.setName((recipe.getName() == null ? updatedRecipe.getName() : recipe.getName()));
        //修改食譜名字->判斷 送進來的新資料 name是否為空，空代表原本的名字不用更改，所以set原本的名字
        updatedRecipe.setCookTime(recipe.getCookTime());
        return  recipeRepository.save(updatedRecipe);
         }
    return  null; //查詢的id不存在，返回null
    }

    //刪除食譜
    public void deleteRecipeById(Long id){
        Optional<Recipe> opt = recipeRepository.findById(id);
        opt.ifPresent(recipe -> recipeRepository.deleteById(recipe.getId()));
    }


}
