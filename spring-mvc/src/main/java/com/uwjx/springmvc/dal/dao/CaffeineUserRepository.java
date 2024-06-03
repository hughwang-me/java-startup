package com.uwjx.springmvc.dal.dao;

import com.uwjx.springmvc.dal.entity.CaffeineUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaffeineUserRepository extends JpaRepository<CaffeineUser, Integer> {
}
