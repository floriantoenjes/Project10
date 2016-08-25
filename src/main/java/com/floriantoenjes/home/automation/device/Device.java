package com.floriantoenjes.home.automation.device;

import com.floriantoenjes.home.automation.control.Control;
import com.floriantoenjes.home.automation.core.BaseEntity;
import com.floriantoenjes.home.automation.room.Room;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Device extends BaseEntity {
    private String deviceName;
    @ManyToOne
    private Room room;
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    private List<Control> controls;

    protected Device() {
        super();
        controls = new ArrayList<>();
    }

    public Device(String equipmentName) {
        this();
        this.deviceName = equipmentName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Control> getControls() {
        return controls;
    }

    public void addControl(Control control) {
        control.setDevice(this);
        controls.add(control);
    }
}
