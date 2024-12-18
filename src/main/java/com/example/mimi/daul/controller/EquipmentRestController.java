package com.example.mimi.daul.controller;

import com.example.mimi.daul.entity.Category;
import com.example.mimi.daul.entity.EquipmentEntity;
import com.example.mimi.daul.entity.Status;
import com.example.mimi.daul.service.EquipmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentRestController {
    private  final EquipmentServiceImpl equipmentService;

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody EquipmentEntity equipmentEntity) {
        equipmentService.insert(
                equipmentEntity.getSerialNum(),
                equipmentEntity.getStatus().name(),
                equipmentEntity.getCategory().name());
        return ResponseEntity.status(HttpStatus.CREATED).body("su");
    }

    @PostMapping("/findByMgmNum")
    public ResponseEntity<EquipmentEntity> findByMgmNum(@RequestParam Long mgmNum) {
        EquipmentEntity equipment = equipmentService.findByMgmNum(mgmNum);

        return ResponseEntity.ok(equipment);
    }


    @PostMapping("/update")
    public void update(@RequestParam Long mgmNum,@RequestParam Status str1, @RequestParam Category str2) {
        Status status = Status.valueOf(str1.name());
        Category category = Category.valueOf(str2.name());
        EquipmentEntity equipment = equipmentService.findByMgmNum(mgmNum);
        equipmentService.update(new EquipmentEntity(mgmNum,equipment.getSerialNum(),status,category));
    }

    @PostMapping("/delete")
    public void delete(@RequestParam Long mgmNum) {
        EquipmentEntity equipment= equipmentService.findByMgmNum(mgmNum);
        equipmentService.delete(mgmNum);

    }


    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        List<EquipmentEntity> equipmentList = equipmentService.findAll();
        return ResponseEntity.ok(equipmentList);
    }
}
