package tacos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tacos.data.IngredientRepository;

@SpringBootTest
class TacoCloudApplicationTests {

	@Autowired
	private IngredientRepository ingredientRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testIngredients(){
		List<Ingredient> ingredients = ingredientRepo.findByNameIsLikeAndTypeOrderByName("%Tortilla%",
				Ingredient.Type.WRAP);
		assertEquals(2, ingredients.size());
		assertEquals("Corn Tortilla", ingredients.get(0).getName());
	}

}
