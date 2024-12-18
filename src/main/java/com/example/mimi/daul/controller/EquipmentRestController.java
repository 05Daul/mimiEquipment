package com.example.mimi.daul.controller;

import com.example.mimi.daul.service.EquipmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
public class EquipmentRestController {
    EquipmentServiceImpl equipmentService;
}
