package com.floriantoenjes.home.automation.control;

import com.floriantoenjes.home.automation.core.BaseEntity;
import com.floriantoenjes.home.automation.equipment.Equipment;

import javax.persistence.ManyToOne;

public class Control extends BaseEntity{
    private String controlName;
    private Double value;
    @ManyToOne
    private Equipment equipment;

    protected Control() {
        super();
    }

    public Control(String controlName, Double value) {
        this.controlName = controlName;
        this.value = value;
    }

    public String getControlName() {
        return controlName;
    }

    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}