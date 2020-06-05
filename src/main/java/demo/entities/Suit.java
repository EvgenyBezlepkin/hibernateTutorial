package demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SUIT")
public class Suit implements Serializable {

    @Id
    @Column(name = "SUIT_ID", nullable = false)
    private String suit;

    @ManyToMany
    @JoinTable(name = "DANCER_SUIT",
            joinColumns = @JoinColumn(name = "SUIT_ID"),
            inverseJoinColumns = @JoinColumn(name = "DANCER_ID"))
    private Set<Singer> singers = new HashSet<>();

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Set<Singer> getSingers() {
        return singers;
    }

    public void setSingers(Set<Singer> singers) {
        this.singers = singers;
    }
}