package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {
    @Test
    void testCreateWithName() {
        Recipe recipe = new Recipe("Healing potion");

        assertEquals("Healing potion", recipe.getName());
    }

    @Test
    void testCreateWithTwoParameters() {
        Recipe recipe = new Recipe("Healing potion", "Gives health.");

        assertEquals("Healing potion", recipe.getName());
        assertEquals("Gives health.", recipe.getDescription());
    }

    @Test
    void testAddIngredients() {
        Recipe recipe = new Recipe("Healing potion", "Gives health.");

        recipe.addIngredient("Root", "Water");
        assertEquals(2, recipe.getIngredients().size());
        assertEquals("Water", recipe.getIngredients().get(1));
    }
}