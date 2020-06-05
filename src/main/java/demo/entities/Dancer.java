package demo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("D")
@NamedQueries({
        @NamedQuery(name=Dancer.FIND_BY_ID,
                query="select d from Dancer d where d.id = :id"),
        @NamedQuery(name=Dancer.FIND_BY_FIRST_NAME,
                query="select d from Dancer d where d.firstName = :firstName"),
})
public class Dancer extends Performer{

    public static final String FIND_BY_ID = "Dancer.findById";
    public static final String FIND_BY_FIRST_NAME = "Dancer.findByFirstName";

    // FetchType.EAGER необходим для того, чтобы при запросе dancer также подгружать поле коллекции
    // встроенная коллекция - аналог связей toMany
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="SUITS",
            joinColumns = @JoinColumn(name="ID"))
    @Column(name="suit_name")
    protected Set<Suit> suits = new HashSet<>();

    public Set<Suit> getSuits() {
        return suits;
    }

    public void setSuits(Set<Suit> suits) {
        this.suits = suits;
    }

    public boolean addSuit(Suit suit) {
        return getSuits().add(suit);
    }
}
