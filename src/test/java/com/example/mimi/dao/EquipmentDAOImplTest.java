package com.example.mimi.dao;


import com.example.mimi.daul.dao.EquipmentDAO;
import com.example.mimi.daul.entity.Category;
import com.example.mimi.daul.entity.EquipmentEntity;
import com.example.mimi.daul.entity.Status;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


@Transactional
@SpringBootTest
@Rollback(value = false)
public class EquipmentDAOImplTest {
    @Autowired
    private EquipmentDAO dao;

    @Test
    public void insert() {
        dao.insert("11212", "BREAKDOWN", "LAPTOP");
        System.out.println("dao = " + dao);
    }

    @Test
    public void findByMgmNum() {
        dao.findByMgmNum(2L);
        System.out.println(dao.findByMgmNum(2L));
    }

    ;

    @Test
    public void delete() {
        dao.delete(2L);
    }

    @Test
    public void update() {
        Status status = Status.valueOf("REPAIRING");
        Category category = Category.valueOf("LAPTOP");
        dao.update(new EquipmentEntity(1L, "4567", status, category));
    }

    @Test
    void findAll() {
        System.out.println("dao.findAll() = " + dao.findAll());
    }

}
