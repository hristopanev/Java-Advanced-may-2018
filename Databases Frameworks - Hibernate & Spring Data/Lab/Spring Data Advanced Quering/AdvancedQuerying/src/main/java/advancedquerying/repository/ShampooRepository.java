package advancedquerying.repository;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Label;
import advancedquerying.domain.entities.Shampoo;
import advancedquerying.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllByBrand(String brand);

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllByLabel(Label label);

    List<Shampoo> findAllByLabelAndSize(Label label, Size size);

    List<Shampoo> findAllByLabelOrSizeOrderById(Label label, Size size);

    List<Shampoo> findAllByPriceAndOrderByPriceIdDesc(BigDecimal price);

    @Query("SELECT s FROM advancedquerying.domain.entities.Shampoo AS s JOIN s.ingredients AS i WHERE i IN :ingredients")
    List<Shampoo> findByIngredientsIn(@Param(value = "ingredients") Set<Ingredient> ingredients);
}
