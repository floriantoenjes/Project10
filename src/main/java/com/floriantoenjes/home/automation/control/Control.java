package com.floriantoenjes.home.automation.control;

import com.floriantoenjes.home.automation.core.BaseEntity;
import com.floriantoenjes.home.automation.equipment.Equipment;
import com.floriantoenjes.home.automation.value.Value;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Control extends BaseEntity{
    private String controlName;
    @OneToMany(mappedBy = "control", cascade = CascadeType.ALL)
    private List<Value> values;
    @ManyToOne
    private Equipment equipment;

    protected Control() {
        super();
        this.values = new ArrayList<>();
    }

    public Control(String controlName) {
        this();
        this.controlName = controlName;
    }

    public String getControlName() {
        return controlName;
    }

    public void setControlName(String controlName) {
        this.controlName = controlName;
    }

    public List<Value> getValues() {
        return values;
    }

    public void addValue(Value value) {
        value.setControl(this);
        values.add(value);
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}