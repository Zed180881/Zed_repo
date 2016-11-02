package springprofiles.kindergarten;

import springprofiles.Food;
import springprofiles.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServicelmpl implements FoodProviderService {
    @Override
    public List<Food> provideLunchSet() {
        List<Food> lunchSet = new ArrayList<>();
        lunchSet.add(new Food("Milk"));
        lunchSet.add(new Food("Biscuits"));
        return lunchSet;
    }
}
