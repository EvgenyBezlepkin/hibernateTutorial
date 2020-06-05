package demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

// TODO класс встраиваемой коллекции (встроена в класс Dancer)
// если встраиваемый класс не является сущностью
@Embeddable
public class Suit implements Serializable {

    @Column(name = "SUIT")
    private String suit;
    private int height;
    private int weight;

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Suit{" +
                "suit='" + suit + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}