package demo.dao;


import demo.entities.Instrument;

/**
 * Created by iuliana.cosmina on 4/23/17.
 */
public interface InstrumentDao {

	Instrument save(Instrument instrument);
	Long countInstrument();

}
