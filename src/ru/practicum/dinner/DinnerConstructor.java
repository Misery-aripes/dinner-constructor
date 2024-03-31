package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DinnerConstructor {
    private final HashMap<String, ArrayList<String>> dishes;

    public DinnerConstructor() {
        this.dishes = new HashMap<>();
    }

    public void addDish(String type, String name) {
        if (!dishes.containsKey(type)) {
            dishes.put(type, new ArrayList<>());
        }
        dishes.get(type).add(name);
    }

    public List<String> getDishesByType(String type) {
        List<String> dishesOfType = dishes.get(type);
        return Objects.requireNonNullElseGet(dishesOfType, ArrayList::new);
    }
}
