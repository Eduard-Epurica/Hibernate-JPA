package com.eduard.cruddemo.dao;

import com.eduard.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //Define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student aStudent) {
        this.entityManager.persist(aStudent );
    }
}
