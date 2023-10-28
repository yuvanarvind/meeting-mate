package com.example.demo.controller;

import com.example.demo.dto.RoomBookingDetails;
import com.example.demo.service.MeetingService;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MeetingController {

    private final MeetingService meetingService;

    @GetMapping("room/{roomNo}")
    public Boolean roomAvailability(@PathVariable int roomNo) {
        return meetingService.roomAvailability(roomNo);
    }

    @PostMapping("add-reservation")
    public JSONObject saveReservationDetails(@Valid @RequestBody RoomBookingDetails roomBookingDetails) {
        return meetingService.saveReservationDetails(roomBookingDetails);
    }

    @GetMapping("get-reservation-details/{roomNo}")
    public JSONObject getReservationDetails(@PathVariable int roomNo) {
        return meetingService.getReservationDetails(roomNo);
    }

    @GetMapping("cancel-reservation/{roomNo}")
    public JSONObject cancelReservation(@PathVariable int roomNo) {
        return meetingService.cancelReservation(roomNo);
    }
}