package demo.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {

	@Id
	@Column(name = "INSTRUMENT_ID", nullable = false)
	private String instrumentId;

	// вставляет переменную перечисления вместо порядкового номера
	@Enumerated(EnumType.STRING)
	@Column(name = "INSTRUMENT_TYPE", nullable = false)
	private InstrumentType instrumentType;

	@ManyToMany
	@JoinTable(name = "singer_instrument",
			joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
			inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
	private Set<Singer> singers = new HashSet<>();


	public String getInstrumentId() {
		return this.instrumentId;
	}

	public Set<Singer> getSingers() {
		return this.singers;
	}

	public void setSingers(Set<Singer> singers) {
		this.singers = singers;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

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