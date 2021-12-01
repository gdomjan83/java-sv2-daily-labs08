package day02;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private List<String> ingredients = new ArrayList<>();
    private String description;

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(String name, String description) {
        this(name);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void addIngredient(String... ingredientsAdded) {
        for (int i = 0; i < ingredientsAdded.length; i++) {
            ingredients.add(ingredientsAdded[i]);
        }
    }
}
