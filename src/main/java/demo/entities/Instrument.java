package demo.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {

	private String instrumentId;
	private InstrumentType instrumentType;
	private Set<Singer> singers = new HashSet<>();


	@Id
	@Column(name = "INSTRUMENT_ID", nullable = false)
	public String getInstrumentId() {
		return this.instrumentId;
	}

	// TODO аннотация @ManyToMany - подчиненная таблица
	@ManyToMany
	// определяет имя и параметры соединяющей таблицы
	// joinColumns - имя поля с этой стороны, foreignKey - имя внешнего ключа
	// inverseJoinColumns - имя поля с противоположной стороны
	@JoinTable(name = "SINGER_INSTRUMENT",
			joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
			inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
	public Set<Singer> getSingers() {
		return this.singers;
	}

	public void setSingers(Set<Singer> singers) {
		this.singers = singers;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	// TODO втроенный Enum
	// аннотация вставляет переменную перечисления вместо порядкового номера
	@Enumerated(EnumType.STRING)
	@Column(name = "INSTRUMENT_TYPE", nullable = false)
	public InstrumentType getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	@Override
	public String toString() {
		return "Instrument :" + getInstrumentId();
	}
}