package org.example.mate_matcher.model.storage;

import lombok.Data;

import java.util.List;

@Data
public class FFHouse {
    private String houseId;
    private String flatNo;
    private String addressLine1;
    private String locality;
    private String pincode;
    private String state; // can use an enum here
    private int noOfRooms;
    private int noOfWashRooms;
    private List<FFPerson> existingTenants;
    private List<FFRoom> rooms;
    private FFHousePreferences housePreferences;

}
