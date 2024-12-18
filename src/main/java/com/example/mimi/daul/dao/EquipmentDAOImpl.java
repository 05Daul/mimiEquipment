package com.example.mimi.daul.dao;

import com.example.mimi.daul.entity.Category;
import com.example.mimi.daul.entity.EquipmentEntity;
import com.example.mimi.daul.entity.Status;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EquipmentDAOImpl implements EquipmentDAO {
    private final EntityManager em;

    @Override
    public void insert(String mgmNum, String statusStr, String categoryStr) {
        Status status = Status.valueOf(statusStr);
        Category category = Category.valueOf(categoryStr);
        em.persist(new EquipmentEntity(mgmNum, status, category));
    }

    @Override
    public EquipmentEntity findByMgmNum(Long MgmNum) {
        return em.find(EquipmentEntity.class, MgmNum);
    }

    @Override
    public void delete(Long mgmNum) {
        EquipmentEntity delete = em.find(EquipmentEntity.class, mgmNum);
        em.remove(delete);

    }

    @Override
    public void update(EquipmentEntity dto) {
        EquipmentEntity update = em.find(EquipmentEntity.class, dto.getMgmNum());
        update.setSerialNum(dto.getSerialNum());
        update.setCategory(dto.getCategory());
        update.setStatus(dto.getStatus());
    }

    @Override
    public List<EquipmentEntity> findAll() {
        List<EquipmentEntity> list = em.createQuery("select e from EquipmentEntity e", EquipmentEntity.class).getResultList();
        return list;
    }
}
