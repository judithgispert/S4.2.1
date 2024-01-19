package cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Services;

import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Domain.Fruit;
import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Repository.IFruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService implements IFruitService{
    @Autowired
    private IFruitRepo fruitRepo;
    @Override
    public void createFruit(Fruit fruit) {
        fruitRepo.save(fruit);
    }

    @Override
    public Fruit getFruitById(int id) {
        Fruit fruitObj = null;
        Optional<Fruit> fruit = fruitRepo.findById(id);
        if(fruit.isPresent()){
            fruitObj = fruit.get();
        }
        return fruitObj;
    }

    @Override
    public List<Fruit> getFruits() {
        return fruitRepo.findAll();
    }

    @Override
    public Fruit updateFruit(Fruit newFruit, int id) {
        Fruit fruitObj = null;
        Optional<Fruit> oldFruit = fruitRepo.findById(id);
        if(oldFruit.isPresent()){
            Fruit updatedFruit = oldFruit.get();
            updatedFruit.setName(newFruit.getName());
            updatedFruit.setQuantityKg(newFruit.getQuantityKg());
            fruitObj = fruitRepo.save(updatedFruit);
        }
        return fruitObj;
    }

    @Override
    public boolean deleteFruit(int id) {
        Optional <Fruit> fruitData = fruitRepo.findById(id);
        boolean deleted = false;
        if(fruitData.isPresent()){
            fruitRepo.deleteById(id);
            deleted = true;
        }
        return deleted;
    }
}
