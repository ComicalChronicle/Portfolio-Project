import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * HealthSystem class that represents a simple health system for an entity in a
 * game or simulation.
 *
 * It includes methods to modify health and check the entity's status.
 *
 * This class demonstrates the feasibility of using NaturalNumber to represent
 * health and various methods to interact with the health system.
 *
 */
public class HealthSystem {

    /**
     * Representation of the current health of the entity. This value is stored
     * as a NaturalNumber to ensure it cannot be negative.
     */
    private NaturalNumber health;

    /**
     * Representation of the maximum health of the entity. This value is stored
     * as a NaturalNumber and represents the highest health value the entity can
     * reach.
     */
    private NaturalNumber maxHealth;

    /**
     * Constructor to initialize HealthSystem with a specific amount of health.
     *
     * @param initialHealth
     *            initial health value
     */
    public HealthSystem(int initialHealth) {
        this.health = new NaturalNumber1L(initialHealth);
        // Assume max health equals initial health
        this.maxHealth = new NaturalNumber1L(initialHealth);
    }

    /**
     * Method to get the current health of the entity.
     *
     * @return current health as a NaturalNumber
     */
    public NaturalNumber getHealth() {
        return this.health;
    }

    /**
     * Method to heal the entity by a specific amount. Health cannot exceed max
     * health.
     *
     * @param amount
     *            amount of health to restore
     */
    public void heal(int amount) {
        NaturalNumber healAmount = new NaturalNumber1L(amount);
        this.health.add(healAmount);

        // Ensure health does not exceed max health
        if (this.health.compareTo(this.maxHealth) > 0) {
            this.health.copyFrom(this.maxHealth);
        }
    }

    /**
     * Method to deal damage to the entity, reducing its health.
     *
     * @param amount
     *            amount of damage to deal
     */
    public void takeDamage(int amount) {
        NaturalNumber damage = new NaturalNumber1L(amount);
        if (this.health.compareTo(damage) >= 0) {
            this.health.subtract(damage);
        } else {
            this.health.clear(); // Set health to zero if damage exceeds current health
        }
    }

    /**
     * Method to check if the entity is alive. An entity is alive if its health
     * is greater than zero.
     *
     * @return true if the entity is alive, false otherwise
     */
    public boolean isAlive() {
        return !this.health.isZero();
    }

    /**
     * Main method to demonstrate the use of HealthSystem in a variety of use
     * cases.
     *
     * @param args
     *            command-line arguments (not used)
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();

        // Initialize a HealthSystem with 100 health
        HealthSystem player = new HealthSystem(100);

        // Show initial health and status
        out.println("Player's initial health: " + player.getHealth());
        out.println("Is the player alive? " + player.isAlive());

        // Demonstrate taking damage
        player.takeDamage(30);
        out.println("Player's health after taking 30 damage: "
                + player.getHealth());

        // Demonstrate healing
        player.heal(20);
        out.println("Player's health after healing 20: " + player.getHealth());

        // Demonstrate taking fatal damage
        player.takeDamage(100);
        out.println("Player's health after taking 100 damage: "
                + player.getHealth());
        out.println("Is the player alive? " + player.isAlive());

        out.close();
        in.close();
    }
}
