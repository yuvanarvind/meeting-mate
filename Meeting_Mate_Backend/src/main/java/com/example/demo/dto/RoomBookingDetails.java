package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NotNull
public class RoomBookingDetails {

    private Integer roomNo;

    private String title;

    private String startTime;

    private String endTime;

    private List<Participant> participants;
}
