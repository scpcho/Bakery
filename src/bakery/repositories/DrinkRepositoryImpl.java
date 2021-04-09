package bakery.repositories;

import bakery.entities.drinks.interfaces.Drink;
import bakery.repositories.interfaces.DrinkRepository;

import java.util.ArrayList;
import java.util.Collection;

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private Collection<Drink> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }


    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        for (Drink drink : models) {
            if(drink.getName().equals(drinkName) && drink.getBrand().equals(drinkBrand)){
                return drink;
            }
        }
        return null;
    }

    @Override
    public Collection<Drink> getAll() {
        return this.models;
    }

    @Override
    public void add(Drink drink) {
        if(drink!= null) {
            models.add(drink);
        }
    }
}
