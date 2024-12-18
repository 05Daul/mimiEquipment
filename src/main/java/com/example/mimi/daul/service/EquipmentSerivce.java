package com.example.mimi.daul.service;

import com.example.mimi.daul.entity.EquipmentEntity;

import java.util.List;

public interface EquipmentSerivce {
    void insert(String serialNum, String statusStr, String categoryStr);

    EquipmentEntity findByMgmNum(Long MgmNum);

    void delete(Long mgmNum);

    void update(EquipmentEntity dto);

    List<EquipmentEntity> findAll();

}
