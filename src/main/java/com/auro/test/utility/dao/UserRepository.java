package com.auro.test.utility.dao;

import com.auro.test.utility.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByUserNameAndPassword(String user, String password);
    User findByUserName(String userName);
}
