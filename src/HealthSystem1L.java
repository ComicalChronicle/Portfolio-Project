import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;

/**
 * {@code HealthSystem} represented as a {@code NaturalNumber} with
 * implementations of primary methods for managing health points.
 *
 * @convention <pre>
 * this.health is a NaturalNumber and 0 <= this.health <= this.maxHealth
 * </pre>
 * @correspondence <pre>
 * this = [the current health points represented by this.health]
 * maxHealth = [the maximum allowable health points]
 * </pre>
 *
 */
public class HealthSystem1L extends HealthSystemSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of current health.
     */
    private NaturalNumber health;

    /**
     * Maximum allowable health.
     */
    private NaturalNumber maxHealth;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.health = new NaturalNumber1L();
        this.maxHealth = new NaturalNumber1L();
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor initializing to maximum health.
     */
    public HealthSystem1L() {
        this.createNewRep();
        this.maxHealth.setFromInt(100); // Setting a default max health
        this.health.copyFrom(this.maxHealth); // Character starts at full health
    }

    /**
     * Constructor from specified maximum health.
     *
     * @param maxHealthValue
     *            Maximum allowable health points
     */
    public HealthSystem1L(int maxHealthValue) {
        this.createNewRep();
        assert maxHealthValue > 0 : "Violation of: maxHealthValue > 0";
        this.maxHealth.setFromInt(maxHealthValue);
        this.health.copyFrom(this.maxHealth);
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final HealthSystem1L newInstance() {
        return new HealthSystem1L();
    }

    @Override
    public final void clear() {
        this.health.clear();
    }

    @Override
    public final void transferFrom(HealthSystemKernel source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";

        // Cast source to HealthSystem1L to access specific fields
        HealthSystem1L localSource = (HealthSystem1L) source;
        this.health.transferFrom(localSource.health);
        this.maxHealth.transferFrom(localSource.maxHealth);
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void takeDamage(int damage) {
        assert damage >= 0 : "Violation of: damage >= 0";

        NaturalNumber damageAmount = new NaturalNumber1L(damage);
        if (this.health.compareTo(damageAmount) >= 0) {
            this.health.subtract(damageAmount);
        } else {
            this.health.clear(); // Health cannot go below zero
        }
    }

    @Override
    public final void heal(int amount) {
        assert amount >= 0 : "Violation of: amount >= 0";

        NaturalNumber healAmount = new NaturalNumber1L(amount);
        this.health.add(healAmount);
        if (this.health.compareTo(this.maxHealth) > 0) {
            this.health.copyFrom(this.maxHealth); // Enforce max health limit
        }
    }

    @Override
    public final boolean isAlive() {
        return !this.health.isZero();
    }

    @Override
    public final int getHealth() {
        return this.health.toInt();
    }

    @Override
    public final int maxHealth() {
        return this.maxHealth.toInt();
    }

    @Override
    public final void updateMaxHealth(int newMaxHealth) {
        assert newMaxHealth > 0 : "Violation of: newMaxHealth > 0";

        NaturalNumber newMax = new NaturalNumber1L(newMaxHealth);
        this.maxHealth.copyFrom(newMax);

        // Ensure current health does not exceed new maximum
        if (this.health.compareTo(this.maxHealth) > 0) {
            this.health.copyFrom(this.maxHealth);
        }
    }
}
