package com.example.mimi.daul.service;

import com.example.mimi.daul.dao.EquipmentDAO;
import com.example.mimi.daul.entity.EquipmentEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentSerivce {
    private final EquipmentDAO equipmentDAO;

    @Override
    public void insert(String serialNum, String statusStr, String categoryStr) {
        equipmentDAO.insert(serialNum, statusStr, categoryStr);
    }

    @Override
    public EquipmentEntity findByMgmNum(Long MgmNum) {
        return equipmentDAO.findByMgmNum(MgmNum);
    }

    @Override
    public void delete(Long mgmNum) {
        equipmentDAO.delete(mgmNum);
    }

    @Override
    public void update(EquipmentEntity dto) {
equipmentDAO.update(dto);
    }

    @Override
    public List<EquipmentEntity> findAll() {
        return equipmentDAO.findAll();
    }
}
