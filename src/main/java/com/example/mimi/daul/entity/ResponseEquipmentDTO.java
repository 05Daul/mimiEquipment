package com.example.mimi.daul.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEquipmentDTO {
    private Long mgmNum;
    private String serialNum;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Category category;

    public ResponseEquipmentDTO(Long mgmNum, String serialNum) {
        this.mgmNum = mgmNum;
        this.serialNum = serialNum;
    }


    public ResponseEquipmentDTO(Long mgmNum, Status status) {
        this.mgmNum = mgmNum;
        this.status = status;
    }
}


