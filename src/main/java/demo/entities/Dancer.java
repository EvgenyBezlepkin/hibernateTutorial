package demo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("D")
public class Dancer extends Performer{

    @ManyToMany
    // определяет параметры соединяющей таблицы
    // joinColumns - имя поля с этой стороны, foreignKey - имя внешнего ключа
    // inverseJoinColumns - имя поля с противоположной стороны
    @JoinTable(name = "DANCER_SUIT",
            joinColumns = @JoinColumn(name = "DANCER_ID"),
            inverseJoinColumns = @JoinColumn(name = "SUIT_ID"))
    private Set<Suit> suits = new HashSet<>();
}
