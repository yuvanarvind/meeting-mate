package com.example.demo.dto;

import lombok.Data;

@Data
public class RoomAvailabilityDto {
    Integer roomNo;
    String startTime;
    String endTime;
}