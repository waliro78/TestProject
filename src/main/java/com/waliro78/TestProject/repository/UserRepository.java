package com.waliro78.TestProject.repository;

import com.waliro78.TestProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 3/2/2020.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
