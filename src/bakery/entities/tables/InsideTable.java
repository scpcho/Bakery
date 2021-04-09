package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

public class InsideTable extends BaseTable {
    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, 2.50);
    }

}
