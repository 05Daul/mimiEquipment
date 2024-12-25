package com.example.mimi.daul.service;

import com.example.mimi.daul.entity.Category;
import com.example.mimi.daul.entity.EquipmentEntity;
import com.example.mimi.daul.entity.ResponseEquipmentDTO;
import com.example.mimi.daul.entity.Status;

import java.util.List;
public interface EquipmentSerivce {
    void insert(String serialNum, String statusStr, String categoryStr);

    EquipmentEntity findByMgmNum(String MgmNum);

    void delete(String mgmNum);

    void update(ResponseEquipmentDTO dto);

    void updateStatus(ResponseEquipmentDTO dto);

    void updateSerial(ResponseEquipmentDTO dto);

    List<EquipmentEntity> findstcok(String status, String category);

    int findstock(String status, String category);

    List<EquipmentEntity> findAll();

    List<EquipmentEntity> findFilter(Category category, Status status);
}
