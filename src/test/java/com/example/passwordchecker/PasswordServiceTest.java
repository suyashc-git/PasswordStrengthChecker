
package com.example.passwordchecker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceTest {

    private final PasswordService passwordService =
            new PasswordService();

    @Test
    void shouldReturnWeakForShortPassword() {
        assertEquals("Weak",
                passwordService.checkStrength("abc"));
    }

    @Test
    void shouldReturnStrongForPasswordMeetingAllChecks() {
        assertEquals("Strong",
                passwordService.checkStrength("Abcd123!"));
    }
}
