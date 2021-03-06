package lesson10;

import java.util.HashMap;
import java.util.Map;

import lesson06.Seasons;

public class SeasonQupte {

    private final Map<Seasons, String> map = new HashMap<>();

    public SeasonQupte() {

	map.put(Seasons.WINTER, "Winter is cold");
	map.put(Seasons.SUMMER, "Summer is hot");
	map.put(Seasons.AUTUMN, "Autumn is rainy");
	map.put(Seasons.SPRING, "Spring is shiny");

    }

    public String getQuote(Seasons season) {
	return map.get(season);
	// switch (season) {
	// case WINTER:
	// return "Winter is cold";
	// case SUMMER:
	// return "Summer is hot";
	// case AUTUMN:
	// return "Autumn is rainy";
	// case SPRING:
	// return "Spring is shiny";
	// default:
	// return null;
	// }
    }
}
