package tacos.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tacos.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{

    List<Ingredient> findByNameIsLikeAndTypeOrderByName(String name, Ingredient.Type type);
}