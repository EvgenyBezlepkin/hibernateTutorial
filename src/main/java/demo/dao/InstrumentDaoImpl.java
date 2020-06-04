package demo.dao;


import demo.entities.Instrument;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Query;

/**
 * Created by iuliana.cosmina on 4/23/17.
 */
@Transactional
@Repository("instrumentDao")
public class InstrumentDaoImpl implements InstrumentDao {

	private static final Log logger = LogFactory.getLog(InstrumentDaoImpl.class);

	// создает объекты Session, внутреннее состояние SF неизменно,  internal state includes all of the metadata about ORM.
	private SessionFactory sessionFactory;


	@Override
	public Instrument save(Instrument instrument) {
		sessionFactory.getCurrentSession().saveOrUpdate(instrument);
		logger.info("Instrument saved with id: " + instrument.getInstrumentId());
		return instrument;
	}

	@Override
	public Long countInstrument() {
		return (Long) sessionFactory.getCurrentSession().createQuery("SELECT count(*) from Instrument").getSingleResult();
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
