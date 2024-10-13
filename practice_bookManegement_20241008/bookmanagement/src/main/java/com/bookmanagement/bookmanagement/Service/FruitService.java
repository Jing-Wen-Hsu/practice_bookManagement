package com.bookmanagement.bookmanagement.Service;

import com.bookmanagement.bookmanagement.Entity.Fruit;
import com.bookmanagement.bookmanagement.Repository.FruitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    //新增
    public Fruit addFruit(Fruit fruit){
        return fruitRepository.save(fruit);
    }

    //查詢全部
    public List<Fruit> getAllFruits(){
        return fruitRepository.findAll();
    }

    //查詢指定
    public Fruit getFruitById(Long id){
        //先找出這個id是否真的存在 optioanl允許null
        Optional<Fruit> opt = fruitRepository.findById(id);
        return opt.orElse(null);
    }

    //修改
    public Fruit updateFruitById(Long id,Fruit fruit){
        Optional<Fruit> opt = fruitRepository.findById(fruit.getId());
        if(opt.isPresent()){
            Fruit oldFruit = opt.get(); //取出舊水果資料
            oldFruit.setName((fruit.getName == null? oldFruit.getName():fruit.getName()));
            oldFruit.setQuantity(fruit.getQuantity());
            return fruitRepository.save(oldFruit);
        }
        return null; //查詢的id不存在
    }


    //刪除
    public void deleteFruitById (Long id){
        Optional<Fruit> opt = fruitRepository.findById(id);
        opt.ifPresent(fruit -> fruitRepository.deleteById(fruit.getId()));

    }

}
