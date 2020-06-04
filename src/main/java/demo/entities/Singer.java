package demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "singer")

//@NamedQuery annotation is attached to exactly one entity class or mapped superclass.
// since the scope of named queries is the entire persistence unit, we should select the query name carefully to avoid a collision.
@NamedQueries({
		@NamedQuery(name=Singer.FIND_SINGER_BY_ID,
				query="select distinct s from Singer s " +
						"left join fetch s.albums a " +
						"left join fetch s.instruments i " +
						"where s.id = :id"),
		@NamedQuery(name=Singer.FIND_ALL_WITH_ALBUM,
				query="select distinct s from Singer s " +
						"left join fetch s.albums a " +
						"left join fetch s.instruments i")
})
public class Singer {

	public static final String FIND_SINGER_BY_ID = "Singer.findById";
	public static final String FIND_ALL_WITH_ALBUM = "Singer.findAllWithAlbum";

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(updatable = false)
	protected Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@OneToOne
	private Manager manager;


	// один ко многим - у одного певца много альбомов , свойства опциональны
	// mappedBy - имя таблицы, которая владеет связью
	// fetch() - default LAZY;
	// orphanRemoval - удаляет несвязанные сущности
	@OneToMany(
			mappedBy = "singer",
			cascade=CascadeType.ALL,
			orphanRemoval=true)
	private Set<Album> albums = new HashSet<>();

	// многие ко многим - у одного певца мб много инструментов, у одного инструмента мб много певцов, ненаправленная (нет mapped by)
	@ManyToMany
	// определяет параметры соединяющей таблицы
	// joinColumns - имя поля с этой стороны, foreignKey - имя внешнего ключа
	// inverseJoinColumns - имя поля с противоположной стороны
	@JoinTable(name = "singer_instrument",
			joinColumns = @JoinColumn(name = "SINGER_ID"),
			inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
	private Set<Instrument> instruments = new HashSet<>();


	public Long getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public Set<Instrument> getInstruments() {
		return instruments;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean addAlbum(Album album) {
		album.setSinger(this);
		return getAlbums().add(album);
	}

	public void removeAlbum(Album album) {
		getAlbums().remove(album);
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

	public boolean addInstrument(Instrument instrument) {
		return getInstruments().add(instrument);
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String toString() {
		return "Singer - Id: " + id + ", First name: " + firstName
				+ ", Last name: " + lastName + ", Birthday: " + birthDate;
	}
}
