package com.csb.TrackMe.repository;

import com.csb.TrackMe.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * We don't need to create an implementation of this method since Spring provides dynamic implementation for this
     * interface.
     * See {@link https://docs.spring.io/spring-data/jpa/docs/current/reference/html/}
     *
     * @param emailAddress target email address
     * @return User
     */
    User findByEmailAddress(String emailAddress);

}
