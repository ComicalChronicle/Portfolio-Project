/**
 * HealthSystemKernel enhanced with secondary methods for advanced health
 * management.
 */
public interface HealthSystem extends HealthSystemKernel {

    /**
     * Reports whether the character's health is in a critical state.
     *
     * @return true iff health < 20% of max health
     * @ensures isCritical = (this < 0.2 * MAX_HEALTH)
     */
    boolean isCritical();

    /**
     * Resets the character's health to the maximum value.
     *
     * @updates this
     * @ensures this = MAX_HEALTH
     */
    void resetHealth();

    /**
     * Updates the maximum health value for the character.
     *
     * @param maxHealth
     *            the new maximum health value
     * @replaces this
     * @requires maxHealth > 0
     * @ensures MAX_HEALTH = maxHealth
     */
    void setMaxHealth(int maxHealth);

    /**
     * Returns the maximum health value.
     *
     * @return the maximum health value
     * @ensures getMaxHealth = MAX_HEALTH
     */
    int getMaxHealth();
}