package aptech.fpt.spring.model;

import aptech.fpt.spring.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductModel
        extends PagingAndSortingRepository<Product, Integer> {

    Page<Product> findProductsByPrice(int price, Pageable pageable);

    Page<Product> findProductsByStatus(int status, Pageable pageable);

//    @Query(value = "SELECT p FROM Product p WHERE p.name LIKE '%name%'",
//            nativeQuery = true)
//    Page<Product> findByName(@Param("name") String name, Pageable pageable);


    @Query(value = "SELECT product FROM Product product WHERE product.name LIKE :name% AND product.status = :status")
    Page<Product> findByNameAndStatus(String name, int status, Pageable pageable);
}
