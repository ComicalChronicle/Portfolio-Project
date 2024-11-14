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
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("HealthSystem(");
        result.append("Current Health: ").append(this.getHealth()).append(", ");
        result.append("Max Health: ").append(this.maxHealth()).append(", ");
        result.append("Status: ").append(this.isAlive() ? "Alive" : "Dead");
        return result.append(")").toString();
    }

    /*
     * Other secondary methods ------------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean isCritical() {
        // Critical if current health is less than 20% of maxHealth
        return this.getHealth() < 0.2 * this.maxHealth();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void resetHealth() {
        int currentHealth = this.getHealth();
        this.heal(this.maxHealth() - currentHealth);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void setMaxHealth(int maxHealth) {
        this.updateMaxHealth(maxHealth);
    }

}
