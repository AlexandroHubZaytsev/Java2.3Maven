import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 26_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateUnregisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 56_000_60;
        boolean registered = false;
        long expected = 280;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 14_000_60;
        boolean registered = false;
        long expected = 140;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}