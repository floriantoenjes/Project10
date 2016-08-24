package com.floriantoenjes.home.automation.equipment;

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
public class Equipment extends BaseEntity {
    private String equipmentName;
    @ManyToOne
    private Room room;
    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private List<Control> controls;

    protected Equipment() {
        super();
        controls = new ArrayList<>();
    }

    public Equipment(String equipmentName) {
        this();
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
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
        control.setEquipment(this);
        controls.add(control);
    }
}
