package com.konecranes.service.tests;

import com.konecranes.service.CraneService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CraneServiceTest {
    @Test
    void shouldAllowValidLoad() {
        CraneService service = new CraneService();

        boolean result = service.canLift(1000, 500);

        assertTrue(result);
    }

    @Test
    void shouldThrowExceptionWhenOverCapacity() {
        CraneService service = new CraneService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.canLift(1000, 1500);
        });
    }
}
