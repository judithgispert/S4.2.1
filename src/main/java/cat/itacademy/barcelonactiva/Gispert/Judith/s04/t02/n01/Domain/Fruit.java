package cat.itacademy.barcelonactiva.Gispert.Judith.s04.t02.n01.Domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Fruits")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "Name")
    private String name;
    @Column (name = "QuantityKg")
    private int quantityKg;

    public Fruit(){}
    public Fruit (String name, int quantityKg){
        this.name = name;
        this.quantityKg = quantityKg;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getQuantityKg(){
        return quantityKg;
    }
    public void setName (String name){
        this.name = name;
    }
    public void setQuantityKg(int quantityKg){
        this.quantityKg = quantityKg;
    }

    @Override
    public String toString(){
        return "Id: " + id + ", Name: " + name + ", Quantity KG: " + quantityKg + "KG";
    }


}
