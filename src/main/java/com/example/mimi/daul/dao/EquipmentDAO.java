package com.example.mimi.daul.dao;

import com.example.mimi.daul.entity.Category;
import com.example.mimi.daul.entity.EquipmentEntity;
import com.example.mimi.daul.entity.Status;

import java.util.List;

public interface EquipmentDAO {
    void insert(String serialNum, String statusStr, String categoryStr);

    EquipmentEntity findByMgmNum(Long MgmNum);

    void delete(Long mgmNum);

    void update(EquipmentEntity dto);

    void updateSerialNum(EquipmentEntity dto);

    void updateStatus(EquipmentEntity dto);
    List<EquipmentEntity> findstock(Status status, Category category);
    int findintstock(Status status, Category category);

    List<EquipmentEntity> findAll();
}
