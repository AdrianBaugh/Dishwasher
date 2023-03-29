/**
 * Dish is a class that represents a single dish that can be added to a Dishwasher.
 * YOU DO NOT NEED TO MODIFY THIS CLASS, but you will need to use it when completing the Dishwasher class.
 */

class Dish {
    private final String type;

    public Dish(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Dish otherDish = (Dish) other;
        return type.equals(otherDish.type);
    }

    @Override
    public int hashCode() {
        return getType().hashCode();
    }
}