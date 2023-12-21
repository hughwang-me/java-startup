package com.uwjx.springdatajpa.dao;

import com.uwjx.springdatajpa.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom , Long> {

    Classroom findClassroomByNameLike(String name);

    @Query("from Classroom c where c.name like %:name%")
    List<Classroom> findList(@Param("name") String name);

    List<Classroom> findAllByNameNotNullOrderByScoreDescLevelDesc();
}
