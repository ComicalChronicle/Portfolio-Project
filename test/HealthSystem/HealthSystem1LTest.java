package HealthSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test file for the kernel and standard methods of the HealthSystem
 * component.
 */
public class HealthSystem1LTest {

    /**
     * Test for newInstance() method (Standard method).
     */
    @Test
    public void testNewInstance() {
        HealthSystem hs = new HealthSystem1L();
        HealthSystemKernel hs2 = hs.newInstance();
        assertNotNull(hs2);
        assertNotSame(hs, hs2); // Ensures a new instance was created.
    }

    /**
     * Test for clear() method (Standard method).
     */
    @Test
    public void testClear() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.takeDamage(50);
        hs.clear();
        assertEquals(0, hs.getHealth());
    }

    /**
     * Test for transferFrom() method (Standard method).
     */
    @Test
    public void testTransferFrom() {
        HealthSystem hs1 = new HealthSystem1L();
        hs1.updateMaxHealth(100);
        hs1.takeDamage(30);
        HealthSystem hs2 = new HealthSystem1L();
        hs2.transferFrom(hs1);
        assertEquals(0, hs1.getHealth());
        assertEquals(0, hs1.maxHealth());
        assertEquals(70, hs2.getHealth());
        assertEquals(100, hs2.maxHealth());
    }

    /**
     * Test for takeDamage() method (Kernel method).
     */
    @Test
    public void testTakeDamage() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.takeDamage(30);
        assertEquals(70, hs.getHealth());
    }

    /**
     * Test for heal() method (Kernel method).
     */
    @Test
    public void testHeal() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.takeDamage(50);
        hs.heal(20);
        assertEquals(70, hs.getHealth());
    }

    /**
     * Additional Test for heal() method (Kernel method).
     */
    @Test
    public void testHeal2() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.takeDamage(100);
        hs.heal(20);
        assertEquals(0, hs.getHealth());
    }

    /**
     * Test for isAlive() method (Kernel method).
     */
    @Test
    public void testIsAlive() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        assertTrue(hs.isAlive());
        hs.takeDamage(100);
        assertFalse(hs.isAlive());
    }

    /**
     * Test for getHealth() method (Kernel method).
     */
    @Test
    public void testGetHealth() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(100);
        hs.takeDamage(20);
        assertEquals(80, hs.getHealth());
    }

    /**
     * Test for maxHealth() method (Kernel method).
     */
    @Test
    public void testMaxHealth() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(150);
        assertEquals(150, hs.maxHealth());
    }

    /**
     * Test for updateMaxHealth() method (Kernel method).
     */
    @Test
    public void testUpdateMaxHealth() {
        HealthSystem hs = new HealthSystem1L();
        hs.updateMaxHealth(120);
        assertEquals(120, hs.maxHealth());
    }

}
