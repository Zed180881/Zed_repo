package springprofiles.highschool;

import springprofiles.Food;
import springprofiles.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServicelmpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Coke"));
        lunchSet.add(new Food("Hamburger"));
        lunchSet.add(new Food("French Fries"));
        return lunchSet;
    }
}
