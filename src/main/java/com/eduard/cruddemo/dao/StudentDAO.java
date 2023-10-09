package com.eduard.cruddemo.dao;

import com.eduard.cruddemo.entity.Student;

//Data access object for interfacing with database
public interface StudentDAO {

    void save(Student aStudent);

}
