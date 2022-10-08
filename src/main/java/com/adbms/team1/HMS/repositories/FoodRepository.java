package com.adbms.team1.HMS.repositories;

import com.adbms.team1.HMS.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Integer> {

    @Query(value="call hoteldb.getAllFoods();", nativeQuery=true)
    List<Food> getAllFoods();

    @Query(value="call hoteldb.getFoodById(:id);", nativeQuery=true)
    List<Food> findFoodByDeletedFalse(Integer id);
}
