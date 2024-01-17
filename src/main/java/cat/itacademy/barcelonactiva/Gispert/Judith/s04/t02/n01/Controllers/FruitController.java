package cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Controllers;

import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Domain.Fruit;
import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Repository.IFruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FruitController {
    @Autowired
    private IFruitRepo fruitRepo; //TODO change repo to service

    @PostMapping("/addFruit")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit){
        Fruit fruitObj = fruitRepo.save(new Fruit(fruit.getName(), fruit.getQuantityKg()));
        return new ResponseEntity<>(fruitObj, HttpStatus.OK);
    }

    @GetMapping("/getFruit/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable int id){
        Optional<Fruit> fruitData = fruitRepo.findById(id);
        if(fruitData.isPresent()){
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getAllFruits")
    public ResponseEntity<List<Fruit>> getAllFruits(){
        try{
            List<Fruit> fruits = new ArrayList<>();
            fruitRepo.findAll().forEach(fruits::add);
            if(fruits.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateFruit/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable int id, @RequestBody Fruit newFruitData){
        Optional <Fruit> oldFruitData = fruitRepo.findById(id);
        if(oldFruitData.isPresent()){
            Fruit updatedFruitData = oldFruitData.get();
            updatedFruitData.setName(newFruitData.getName());
            updatedFruitData.setQuantityKg(newFruitData.getQuantityKg());
            Fruit fruitObj = fruitRepo.save(updatedFruitData);
            return new ResponseEntity<>(fruitObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteFruit/{id}")
    public ResponseEntity<Fruit> deleteFruit(@PathVariable int id){
        fruitRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
