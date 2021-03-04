package tacos;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco{
    
    private Long id;

    private Date createdAt;
    @NotNull
    @Size(min=5, message="name should more than 5 charaters.")
    private String name;

    @Size(min=1, message="must have at least 1 ingredient.")
    private List<Ingredient> ingredients;

}
