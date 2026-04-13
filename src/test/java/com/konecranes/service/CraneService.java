package com.konecranes.service;

public class CraneService {
    public boolean canLift(int maxCapacity, int loadWeight) {
        if (loadWeight > maxCapacity) {
            throw new IllegalArgumentException("Capacity exceeded");
        }
        return true;
    }
}
