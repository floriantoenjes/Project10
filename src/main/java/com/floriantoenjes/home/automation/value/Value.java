package com.floriantoenjes.home.automation.value;

import com.floriantoenjes.home.automation.control.Control;
import com.floriantoenjes.home.automation.core.BaseEntity;

import javax.persistence.*;

@Entity
public class Value extends BaseEntity {
    private Double value;
    @ManyToOne
    private Control control;

    public Value() {
        super();
    }

    public Value(Double value) {
        this();
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }
}
