package demo.dao;

import demo.entities.Instrument;
import demo.entities.Manager;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Repository("managerDao")
public class ManagerDaoImpl implements ManagerDao{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Manager save(Manager manager) {
        sessionFactory.getCurrentSession().saveOrUpdate(manager);
        return manager;
    }
}
