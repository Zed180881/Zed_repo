package main.java.collectioninjectionannotationconfig;

import org.springframework.stereotype.Service;

@Service("oracle")
public class BookwormOracle implements Oracle {
    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are а waste of money - use the Internet";
    }
}
