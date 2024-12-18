package com.example.mimi.daul.service;

import com.example.mimi.daul.entity.EquipmentEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EquipmentSerivce {
    void insert(String serialNum, String statusStr, String categoryStr);

    EquipmentEntity findByMgmNum(Long MgmNum);

    void delete(Long mgmNum);

    void update(EquipmentEntity dto);

    List<EquipmentEntity> findAll();

}
