import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DishwasherTest {

    @Test
    public void canCreateWithCapacity() {
        Dishwasher dw10 = new Dishwasher(10);
        assertEquals(10, dw10.getCapacity(),
                "Dishwasher constructor should initialize the capacity.");

        Dishwasher dw100 = new Dishwasher(100);
        assertEquals(100, dw100.getCapacity(),
                "Dishwasher constructor should initialize the capacity.");

        Dishwasher dw20 = new Dishwasher(); // default is 20
        assertEquals(20, dw20.getCapacity(),
                "Default Dishwasher capacity should be 20.");
    }

    @Test
    public void addingDishIncreasesCount() {
        Dishwasher dw = new Dishwasher();

        assertEquals(0, dw.getDishCount(),
                "A newly created Dishwasher should not contain any dishes before a dish is added.");

        Dish plate = new Dish("plate");
        dw.addDish(plate);

        assertEquals(1, dw.getDishCount(),
                "Adding one dish should increase a Dishwasher's dish count by one.");
    }

    @Test
    public void cannotAddDishIfAtCapacity() {
        assertThrows(IllegalStateException.class, () -> {
            // Create a dishwasher with a capacity of 1
            Dishwasher dw = new Dishwasher(1);
            Dish plate = new Dish("plate");

            dw.addDish(plate);
            dw.addDish(plate); // should throw IllegalStateException.
        }, "Trying to add more dishes than a Dishwasher's capacity should throw an IllegalStateException.");
    }

    @Test
    public void cannotAddNullDish() {
        assertThrows(IllegalArgumentException.class, () -> {
            Dishwasher dw = new Dishwasher();
            Dish plate = null;
            dw.addDish(plate); // should throw IllegalArgumentException
        },
                "Trying to add a Dish that has not been initialized should throw an IllegalArgumentException");
    }

    @Test
    public void canGetDishes() {
        Dishwasher dw = new Dishwasher();
        Dish[] dishes = {
                new Dish("plate"),
                new Dish("fork"),
                new Dish("bowl"),
        };

        for (Dish d : dishes) {
            dw.addDish(d);
        }

        for (Dish d : dishes) {
            assertTrue(dw.getAllDishes().contains(d),
                    "A dish that has been added to a Dishwasher should be included in 'all dishes'.");
        }
    }

    @Test
    public void canWashDishes() {
        Dishwasher dw = new Dishwasher();

        assertEquals(dw.getCleanStatus(), CleanStatus.DIRTY,
                "A newly created Dishwasher should be in a 'dirty' state.");

        dw.washDishes();

        assertEquals(dw.getCleanStatus(), CleanStatus.CLEAN,
                "After the dishes have been washed the Dishwasher should be in a 'clean' state.");
    }

    @Test
    public void canEmptyDishwasherWhenDishesAreClean() {
        Dishwasher dw = new Dishwasher();
        Dish plate = new Dish("plate");

        dw.addDish(plate);

        assertEquals(1, dw.getDishCount(),
                "Adding one dish should increase a Dishwasher's dish count by one.");

        dw.washDishes();
        dw.emptyDishwasher();

        assertEquals(0, dw.getDishCount(),
                "After a Dishwasher is emptied, the dish count should be zero.");
    }

    @Test
    public void cannotEmptyDishwasherWhenDishesAreDirty() {
        assertThrows(UnsupportedOperationException.class, () -> {
            Dishwasher dw = new Dishwasher();
            Dish plate = new Dish("plate");
            dw.addDish(plate);

            dw.emptyDishwasher(); // should throw an InvalidOperationException
        }, "When a Dishwasher is in a 'dirty' state, trying to empty it should throw an UnsupportedOperationException.");
    }
}
