package com.example.mimi.daul.entity;

import com.example.mimi.publicEntity.DateEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "device")
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentEntity extends DateEntity {
    @Id
    @GeneratedValue
    private Long mgmNum;
    private String serialNum;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Category category;

    public EquipmentEntity(String serialNum, Status status, Category category) {
        this.serialNum = serialNum;
        this.status = status;
        this.category = category;
    }


    public EquipmentEntity(Long mgmNum, Status status, Category category) {
        this.mgmNum = mgmNum;
        this.status = status;
        this.category = category;
    }
}


