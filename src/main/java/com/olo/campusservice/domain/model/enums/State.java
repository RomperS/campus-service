package com.olo.campusservice.domain.model.enums;

import com.olo.campusservice.domain.exception.value.InvalidStateValueException;

public enum State {
    NEW,
    GOOD_CONDITION,
    DEFECTIVE,
    DAMAGED;

    public static State fromString(String state) {
        try {
            return State.valueOf(state.toUpperCase());
        }catch (IllegalArgumentException e) {
            throw new InvalidStateValueException(state.toUpperCase() + " is not a valid resource state");
        }
    }
}