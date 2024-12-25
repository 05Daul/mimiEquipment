package com.example.mimi.daul;

import com.example.mimi.daul.entity.Category;
import com.example.mimi.daul.entity.EquipmentEntity;
import com.example.mimi.daul.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity,Long> {

    @Query("SELECT e FROM EquipmentEntity e WHERE e.status = :status and e.category = :category")
    List<EquipmentEntity> findByStatus(@Param("status") Status status, @Param("category") Category category);

    @Query("SELECT count(e) FROM EquipmentEntity e WHERE e.status = :status and e.category = :category")
    int findintstock(@Param("status") Status status, @Param("category") Category category);

}
