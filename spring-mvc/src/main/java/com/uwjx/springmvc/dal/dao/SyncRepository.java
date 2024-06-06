package com.uwjx.springmvc.dal.dao;

import com.uwjx.springmvc.dal.entity.SyncData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyncRepository extends JpaRepository<SyncData, Integer> {

    SyncData findFirstByName(String name);
}
