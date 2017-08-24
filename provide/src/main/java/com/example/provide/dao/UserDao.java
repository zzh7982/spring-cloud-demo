package com.example.provide.dao;

import com.example.provide.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * description: userDao
 *
 * @author zhangzh
 * @version [1.0, 2017/8/23]
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
