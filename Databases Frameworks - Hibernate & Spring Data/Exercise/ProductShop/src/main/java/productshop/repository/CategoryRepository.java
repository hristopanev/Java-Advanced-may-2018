package productshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import productshop.domain.dtos.views.CategoryByProductCountDTO;
import productshop.domain.entities.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {



    @Query("SELECT new productshop.domain.dtos.views.CategoryByProductCountDTO(" +
            "c.name, c.products.size, AVG(p.price), SUM(p.price)) " +
            "FROM Category AS c " +
            "JOIN c.products AS p " +
            "GROUP BY c.id " +
            "ORDER BY c.products.size DESC")
    List<CategoryByProductCountDTO> getcategoryByProductCount();



    @Query(value = "SELECT * FROM categories ORDER BY RAND () LIMIT 1", nativeQuery = true)
    Category getRandomEntity();
}
