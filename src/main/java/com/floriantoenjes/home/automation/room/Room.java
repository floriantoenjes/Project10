package com.floriantoenjes.home.automation.room;

import com.floriantoenjes.home.automation.core.BaseEntity;
import com.floriantoenjes.home.automation.equipment.Equipment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room extends BaseEntity{
    private String roomName;
    private Integer squareFootage;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Equipment> equipments;

    protected Room() {
        super();
        equipments = new ArrayList<>();
    }

    public Room(String roomName, Integer squareFootage) {
        this();
        this.roomName = roomName;
        this.squareFootage = squareFootage;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(Integer squareFootage) {
        this.squareFootage = squareFootage;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void addEquipment(Equipment equipment) {
        equipment.setRoom(this);
        equipments.add(equipment);
    }
}
