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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mgmNum;
    @Column(nullable = false, unique = true)
    private String serialNum;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Category category;

    public EquipmentEntity(Long mgmNum, Status status) {
        this.mgmNum = mgmNum;
        this.status = status;
    }

    public EquipmentEntity(String serialNum, Status status, Category category) {
        this.serialNum = serialNum;
        this.status = status;
        this.category = category;
    }

    public EquipmentEntity(Long mgmNum, String serialNum) {
        this.mgmNum = mgmNum;
        this.serialNum = serialNum;
    }

}


