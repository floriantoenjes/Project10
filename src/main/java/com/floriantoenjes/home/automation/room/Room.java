package com.floriantoenjes.home.automation.room;

import com.floriantoenjes.home.automation.core.BaseEntity;
import com.floriantoenjes.home.automation.device.Device;
import org.hibernate.validator.constraints.Range;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room extends BaseEntity{
    private String roomName;

    @Range(min = 0, max = 1000, message = "Cannot be higher than 1000")
    private Integer area;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Device> devices;

    protected Room() {
        super();
        devices = new ArrayList<>();
    }

    public Room(String roomName, Integer area) {
        this();
        this.roomName = roomName;
        this.area = area;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device) {
        device.setRoom(this);
        devices.add(device);
    }
}
