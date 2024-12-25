package com.example.mimi.daul.dao;

import com.example.mimi.daul.EquipmentRepository;
import com.example.mimi.daul.entity.Category;
import com.example.mimi.daul.entity.EquipmentEntity;
import com.example.mimi.daul.entity.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class EquipmentDAOImpl implements EquipmentDAO {
private final EquipmentRepository repository;

    @Override
    public void insert(String serialNum, String statusStr, String categoryStr) {
        Status status = Status.valueOf(statusStr);
        Category category = Category.valueOf(categoryStr);
        repository.save(new EquipmentEntity(serialNum, status, category));
    }


    @Override
    public EquipmentEntity findByMgmNum(Long MgmNum) {
        return repository.findById(MgmNum).orElse(null);

    }

    @Override
    public void delete(Long mgmNum) {
        EquipmentEntity delete = findByMgmNum(mgmNum);
        repository.delete(delete);
    }

    @Override
    public List<EquipmentEntity> findstock(Status status,Category category) {
        return repository.findByStatus(status,category);
    }

    @Override
    public int findintstock(Status status, Category category) {
        return repository.findintstock(status,category);
    }

    @Override
    public void update(EquipmentEntity dto) {
        EquipmentEntity update = findByMgmNum(dto.getMgmNum());
        update.setSerialNum(dto.getSerialNum());
        update.setCategory(dto.getCategory());
        update.setStatus(dto.getStatus());
        repository.save(update);
    }

    @Override
    public void updateSerialNum(EquipmentEntity dto) {
        EquipmentEntity updateSerialNum = findByMgmNum(dto.getMgmNum());
        updateSerialNum.setSerialNum(dto.getSerialNum());
        repository.save(updateSerialNum);
    }

    @Override
    public void updateStatus(EquipmentEntity dto) {
        EquipmentEntity updateStatus = findByMgmNum(dto.getMgmNum());
        updateStatus.setStatus(dto.getStatus());
        repository.save(updateStatus);
    }

    @Override
    public List<EquipmentEntity> findAll() {
        return repository.findAll();
    }

}
