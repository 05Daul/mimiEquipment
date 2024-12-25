package com.example.mimi.daul.service;

import com.example.mimi.daul.dao.EquipmentDAO;
import com.example.mimi.daul.entity.Category;
import com.example.mimi.daul.entity.EquipmentEntity;
import com.example.mimi.daul.entity.ResponseEquipmentDTO;
import com.example.mimi.daul.entity.Status;
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
    public void update(ResponseEquipmentDTO dto) {
        EquipmentEntity entity = new EquipmentEntity(dto.getMgmNum(),dto.getSerialNum(),dto.getStatus(),dto.getCategory());
        equipmentDAO.update(entity);
    }

    @Override
    public List<EquipmentEntity> findstcok(String status, String category) {
        Status status1 = Status.valueOf(status);
        Category category1 = Category.valueOf(category);
        return equipmentDAO.findstock(status1, category1);
    }

    @Override
    public int findstock(String status, String category) {
        Status status1 = Status.valueOf(status);
        Category category1 = Category.valueOf(category);
        return equipmentDAO.findintstock(status1, category1);
    }


    @Override
    public void updateStatus(ResponseEquipmentDTO dto) {
        EquipmentEntity entityStatus = new EquipmentEntity(dto.getMgmNum(), dto.getStatus());
        equipmentDAO.updateStatus(entityStatus);

    }

    @Override
    public void updateSerial(ResponseEquipmentDTO dto) {
        EquipmentEntity entitySerial = new EquipmentEntity(dto.getMgmNum(),dto.getSerialNum());
        equipmentDAO.updateSerialNum(entitySerial);

    }

    @Override
    public EquipmentEntity findByMgmNum(String MgmNum) {
        return equipmentDAO.findByMgmNum(Long.parseLong(MgmNum));
    }

    @Override
    public void delete(String mgmNum) {

        equipmentDAO.delete(Long.parseLong(mgmNum));
    }

    public List<EquipmentEntity> findFilter(Category category, Status status) {
        return equipmentDAO.findstock(status, category);
    }


    @Override
    public List<EquipmentEntity> findAll() {
        return equipmentDAO.findAll();
    }
}
