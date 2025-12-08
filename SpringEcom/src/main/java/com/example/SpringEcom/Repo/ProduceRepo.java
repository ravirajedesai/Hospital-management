package com.example.SpringEcom.Repo;

import com.example.SpringEcom.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduceRepo extends JpaRepository<Product,Integer> {
}
