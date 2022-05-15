package com.example.demo.Repositorio;

import com.example.demo.Entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DemoRepository extends JpaRepository<DemoEntity, Integer> {
    @Query(

           value = "SELECT * FROM demotab",
           nativeQuery = true

    )
    List<DemoEntity> findTuples();

    @Query(

            value = "SELECT * FROM demotab WHERE id = ?1",
            nativeQuery = true

    )
    List<DemoEntity> findTuplaById(Integer id);

}
