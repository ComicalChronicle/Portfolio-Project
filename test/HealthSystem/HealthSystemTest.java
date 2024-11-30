package HealthSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test file for the secondary methods of the abstract class of
 * HealthSystem.
 */
public class HealthSystemTest {

    /**
     * Test for toString() method (Secondary method).
     */
    @Test
    public void testToString() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.takeDamage(50);
        String expected = "HealthSystem(Current Health: 50, Max Health: 100, Status: Alive)";
        assertEquals(expected, hs.toString());
    }

    /**
     * Additional Test for toString() method (Secondary method).
     */
    @Test
    public void testToString2() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.takeDamage(150);
        String expected = "HealthSystem(Current Health: 0, Max Health: 100, Status: Dead)";
        assertEquals(expected, hs.toString());
    }

    /**
     * Test for isCritical() method - critical state.
     */
    @Test
    public void testIsCriticalTrue() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.takeDamage(85);
        assertTrue(hs.isCritical());
    }

    /**
     * Test for isCritical() method - not critical state.
     */
    @Test
    public void testIsCriticalFalse() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.takeDamage(10);
        assertFalse(hs.isCritical());
    }

    /**
     * Test for resetHealth() method.
     */
    @Test
    public void testResetHealth() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.takeDamage(50);
        hs.resetHealth();
        assertEquals(100, hs.getHealth());
    }

    /**
     * Test for setMaxHealth() method.
     */
    @Test
    public void testSetMaxHealth() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.setMaxHealth(150);
        assertEquals(150, hs.maxHealth());
    }

}
