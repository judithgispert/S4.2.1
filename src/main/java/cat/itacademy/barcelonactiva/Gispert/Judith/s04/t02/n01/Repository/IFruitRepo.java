package cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Repository;

import cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFruitRepo extends JpaRepository<Fruit, Integer> {
}
