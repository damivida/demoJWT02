package com.example.demoJWT02.dao;

import com.example.demoJWT02.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * UserDao is an interface that extends the Spring Framework class CrudRepository.
 * CrudRepository class is a generics and takes the following two parameters as arguments- What type of Object will this repository be working with-
 */
@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {

    DAOUser findByUsername(String username);

}
