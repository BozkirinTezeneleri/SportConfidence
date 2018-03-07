package com.sports.User.Repository;

import com.sports.User.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sahin on 07.03.2018.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
