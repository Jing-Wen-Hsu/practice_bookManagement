package com.bookmanagement.bookmanagement.Controller;


import com.bookmanagement.bookmanagement.Entity.Recipe;
import com.bookmanagement.bookmanagement.Service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    //新增食譜
    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe (@RequestBody Recipe recipe){
        return new ResponseEntity<>(recipeService.addRecipe(recipe), HttpStatus.CREATED);
    }

    //查詢食譜 (全部)
    @GetMapping("/a11")
    public ResponseEntity<List<Recipe>> getAllRecipes (){
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    //查詢指定食譜
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById (@PathVariable ("id") Long id){
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    //修改食譜
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipeById (@PathVariable("id") Long id, @RequestBody Recipe recipe){
        recipe.setId(id);
        return  ResponseEntity.ok(recipeService.updateRecipeById(recipe));
    }

    //刪除食譜
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipeById (@PathVariable("id") Long id){
        recipeService.deleteRecipeById(id);
        return ResponseEntity.ok("食譜已成功刪除");
    
    }

}
