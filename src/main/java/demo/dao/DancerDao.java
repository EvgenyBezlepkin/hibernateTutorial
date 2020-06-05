package demo.dao;

import demo.entities.Dancer;
import demo.entities.Singer;

public interface DancerDao {

    Dancer findById(Long id);
    Dancer findByFirstName(String firstName);
    Dancer save(Dancer dancer);
}
