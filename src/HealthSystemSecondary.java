/**
 * Layered implementations of secondary methods for {@code HealthSystem}.
 */
public abstract class HealthSystemSecondary implements HealthSystem {

    /*
     * Common methods (from Object) -------------------------------------------
     */

    /*
     * Override the toString() method to provide a useful representation of the
     * HealthSystem, but we avoid overriding equals() or hashCode(), as this
     * would require access to the representation.
     *
     *
     * @Override public String toString() { StringBuilder result = new
     * StringBuilder("HealthSystem(");
     * result.append("Current Health: ").append(this.getHealth()).append(", ");
     * result.append("Max Health: ").append(this.getMaxHealth()).append(", ");
     * result.append("Status: ").append(this.isAlive() ? "Alive" : "Dead");
     * return result.append(")").toString(); }
     *
     * /* Other secondary methods
     * ------------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean isCritical() {
        assert this.getMaxHealth() > 0 : "Violation of: max health must be positive";
        int healthThreshold = this.getMaxHealth() / 5; // Critical if below 20%
        return this.getHealth() < healthThreshold;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void resetHealth() {
        this.setMaxHealth(this.getMaxHealth()); // Reset health to maximum
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void setMaxHealth(int maxHealth) {
        assert maxHealth > 0 : "Violation of: maxHealth must be positive";
        int currentHealth = this.getHealth();
        if (currentHealth > maxHealth) {
            this.takeDamage(currentHealth - maxHealth); // Reduce health if necessary
        } else {
            this.heal(maxHealth - currentHealth); // Restore up to max health
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int getMaxHealth() {
        // Since we cannot access the representation directly, we return a presumed max
        // from kernel methods
        return this.getHealth() > 0 ? Integer.MAX_VALUE : 0; // Placeholder max health
    }
}
