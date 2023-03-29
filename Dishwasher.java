 

import java.util.List;
import java.util.ArrayList;

/**
 * Dishwasher is a class that represents a machine that washes dishes.
 * Your task is to implement the constructors and methods of this class.
 * You should not need to add any public methods. You only need to fix those that are already there.
 * You will need to add one or more private fields.
 */
public class Dishwasher {
    
    private Dish[] dishwasher; 
    private CleanStatus status = CleanStatus.DIRTY;
    
    
    /**
     * Create a new Dishwasher with a given capacity.
     * @param capacity - The number of dishes that can fit in the dishwasher
     */
    public Dishwasher(int capacity) {
        this.dishwasher = new Dish[capacity];
    }
    
    /**
     * Create a new Dishwasher with a capacity of 20.
     */
    public Dishwasher() {
        this.dishwasher = new Dish[20];
    }

    /**
     * Get the number of dishes that will fit in the dishwasher
     * @return the capacity of the dishwasher
     */
    public int getCapacity() {
        return this.dishwasher.length;
    }

    /**
     * Get the number of dishes currently in the dishwasher
     * @return the dish count
     */
    public int getDishCount() {
        int dishCount = 0;
        for (Dish d : dishwasher) {
            if (d != null) {
                dishCount++;
            }
        }
        return dishCount;
    }

    /**
     * Get the clean or dirty status of the dishes in the dishwasher
     * @return the appropriate CleanStatus enum instance
     */
    public CleanStatus getCleanStatus() {
        return this.status;
    }

    /**
     * Add a new dish to the dishwasher
     * @param newDish - An instance of the Dish class that is to be added to the dishwasher
     * @throws IllegalStateException if the dish count is equal to capacity (i.e. the dishwasher is full)
     */
    public void addDish(Dish newDish) {
        if (newDish == null ) {
                throw new IllegalArgumentException("You cannot add a dish that has not been initialized aka null");
            } 
        
        for (int i = 0; i < dishwasher.length; i++) {
            if (getDishCount() == getCapacity() ) {
                throw new IllegalStateException("The dishwasher is full, you cannot add any more dishes");
            }   
            
            if (dishwasher[i] == null && newDish != null ){
                dishwasher[i] = newDish;
                break;
            }
        }
        // when adding a dish the status needs to be dirty perhaps??
        //status = CleanStatus.DIRTY;
    }

    /**
     * Get all the dishes that are currently in the dishwasher
     * @return a List of Dish objects that contains all the dishes that are currently in the dishwasher
     */
    public List<Dish> getAllDishes() {
        ArrayList<Dish> list = new ArrayList<>();
        for (Dish d : dishwasher) {
            if (d != null) {
                list.add(d);
            }
        }
        return list;
    }

    /**
     * Remove all dishes from the dishwasher ONLY IF the dishes are clean
     * @throws UnsupportedOperationException ONLY IF the dishes are dirty
     */
    public void emptyDishwasher() {
        if (status == CleanStatus.DIRTY || status == null) {
            throw new UnsupportedOperationException("You must wash the dishes before the dishwasher can be emptied");
        }
            
        if (status == CleanStatus.CLEAN)  {
            
            dishwasher = new Dish[getCapacity()];
            //for (Dish d : dishwasher) {
                //if (d != null) {
             //       d = null;
                //}
           // }   
        }
    }

    /**
     * Wash the dishes in the dishwasher
     * This method changes the dishwasher's clean status to CLEAN
     */
    public void washDishes() {
        status = CleanStatus.CLEAN;
        
        
    }
    
    //test
    //test
    //test
    public void TESTaddingDishIncreasesCount() {
        Dishwasher dw = new Dishwasher();

        System.out.println("num of dishes: " + dw.getDishCount() + 
                " A newly created Dishwasher should not contain any dishes before a dish is added.");

        Dish plate = new Dish("plate");
        dw.addDish(plate);

        System.out.println("num of dishes: " +  dw.getDishCount() +
                " Adding one dish should increase a Dishwasher's dish count by one.");
    }
}





