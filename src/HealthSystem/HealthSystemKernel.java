package HealthSystem;

import components.standard.Standard;

/**
 * Health system kernel component with primary methods for managing character's
 * health.
 *
 * @mathmodel type HealthSystemKernel is modeled by the number of health points
 *            (HP).
 * @initially ensures this = MAX_HEALTH (character starts with full health)
 */
public interface HealthSystemKernel extends Standard<HealthSystemKernel> {

    /**
     * Decreases the health by the specified damage amount.
     *
     * @param damage
     *            the amount of damage taken
     * @updates this
     * @requires damage >= 0
     * @ensures this = #this - damage
     */
    void takeDamage(int damage);

    /**
     * Increases the health by the specified amount, up to the maximum health.
     *
     * @param amount
     *            the amount to heal
     * @updates this
     * @requires amount >= 0
     * @ensures this = min(#this + amount, MAX_HEALTH)
     */
    void heal(int amount);

    /**
     * Reports whether the character is alive (health > 0).
     *
     * @return true iff health > 0
     * @ensures isAlive = (this > 0)
     */
    boolean isAlive();

    /**
     * Returns the current health of the character.
     *
     * @return the current health value
     * @ensures getHealth = this
     */
    int getHealth();

    /**
     * Returns the maximum health value.
     *
     * @return the maximum health value
     * @ensures maxHealth > 0
     */
    int maxHealth();

    /**
     * Updates the maximum health to a new specified value.
     *
     * @param newMaxHealth
     *            the new maximum health value
     * @updates this
     * @requires newMaxHealth > 0
     * @ensures maxHealth = newMaxHealth
     */
    void updateMaxHealth(int newMaxHealth);
}
