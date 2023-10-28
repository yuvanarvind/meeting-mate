package com.example.demo.service;

import com.example.demo.dto.RoomBookingDetails;
import com.example.demo.util.DateTimeUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.HashMap;

@Service
public class MeetingService {
    private static final HashMap<Integer, RoomBookingDetails> meetingsMap = new HashMap<>();

    public JSONObject saveReservationDetails(RoomBookingDetails roomBookingDetails) {
        JSONObject jsonObj = new JSONObject();

        if (roomBookingDetails == null) {
            jsonObj.put("message", "Reservation Details are not provided.");
            return jsonObj;
        }

        if (roomBookingDetails.getRoomNo() == null) {
            jsonObj.put("message", "Select a room.");
            return jsonObj;
        }

        if (roomBookingDetails.getParticipants() == null || roomBookingDetails.getParticipants().isEmpty()) {
            jsonObj.put("message", "Minimum one participant needed.");
            return jsonObj;
        }

        LocalTime startTime = DateTimeUtil.parseTime(roomBookingDetails.getStartTime());
        LocalTime endTime = DateTimeUtil.parseTime(roomBookingDetails.getEndTime());

        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            jsonObj.put("message", "Specify correct timings.");
            return jsonObj;
        }

        if (meetingsMap.containsKey(roomBookingDetails.getRoomNo())) {
            jsonObj.put("message", "The meeting room is already reserved by someone.");
            return jsonObj;
        }

        meetingsMap.put(roomBookingDetails.getRoomNo(), roomBookingDetails);
        jsonObj.put("message", "The meeting room is reserved for you.");
        return jsonObj;
    }

    public JSONObject getReservationDetails(int roomNo) {
        JSONObject jsonObj = new JSONObject();

        if (!meetingsMap.containsKey(roomNo)) {
            jsonObj.put("message", "There are no scheduled reservations.");
            return jsonObj;
        }

        RoomBookingDetails roomBookingDetails = meetingsMap.get(roomNo);
        jsonObj.put("title", roomBookingDetails.getTitle());
        jsonObj.put("startTime", roomBookingDetails.getStartTime());
        jsonObj.put("endTime", roomBookingDetails.getEndTime());
        jsonObj.put("participants", roomBookingDetails.getParticipants());
        return jsonObj;

    }

    public JSONObject cancelReservation(int roomNo) {
        JSONObject jsonObj = new JSONObject();

        if (!meetingsMap.containsKey(roomNo)) {
            jsonObj.put("message", "There are no scheduled reservations.");
        } else {
            meetingsMap.remove(roomNo);
            jsonObj.put("message", "Reservation cancelled");
        }

        return jsonObj;
    }

    public Boolean roomAvailability(int roomNo) {
        return !meetingsMap.containsKey(roomNo);
    }
}
