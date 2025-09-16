package com.olo.campusservice.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.olo.campusservice.domain.exception.value.InvalidShiftValueException;

public enum Shift {
    MORNING,
    AFTERNOON,
    NIGHT,
    SATURDAY;

    @JsonCreator
    public static Shift fromString(String shift) {
        try {
            return Shift.valueOf(shift.toUpperCase());
        }catch (IllegalArgumentException e) {
            throw new InvalidShiftValueException(shift.toUpperCase() + " is not a valid Shift value");
        }
    }
}