package com.sports.User.Repository;

import com.sports.User.Model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sahin on 07.03.2018.
 */
@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
