package com.uwjx.springmvc.dal.dao;

import com.uwjx.springmvc.dal.entity.JsKafkaPda;
import com.uwjx.springmvc.dal.entity.SyncData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JsKafkaPdaRepository extends JpaRepository<JsKafkaPda, Integer> {

    JsKafkaPda findFirstByName(String name);
}
