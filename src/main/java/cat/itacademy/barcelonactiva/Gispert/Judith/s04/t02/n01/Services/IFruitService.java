package cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Services;

import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Domain.Fruit;

import java.util.List;

public interface IFruitService {
    public void createFruit(Fruit fruit);
    public Fruit getFruitById(int id);
    public List<Fruit> getFruits();
    public Fruit updateFruit(Fruit newFruit, int id);
    public boolean deleteFruit(int id);

}
