package demo.dao;

import demo.entities.Dancer;
import demo.entities.Singer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Repository("dancerDao")
public class DancerDaoImpl implements DancerDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Dancer save(Dancer dancer) {
            sessionFactory.getCurrentSession().saveOrUpdate(dancer);
            return dancer;
    }

    @Transactional(readOnly = true)
    public Dancer findById(Long id) {
        return (Dancer) sessionFactory.getCurrentSession().
                getNamedQuery(Dancer.FIND_BY_ID).
                setParameter("id", id).uniqueResult();
    }

    @Override
    public Dancer findByFirstName(String firstName) {
        return (Dancer) sessionFactory.getCurrentSession().
                getNamedQuery(Dancer.FIND_BY_FIRST_NAME).
                setParameter("firstName", firstName).uniqueResult();
    }

}
