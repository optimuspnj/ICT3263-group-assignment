package com.adbms.team1.HMS.repositories;

import com.adbms.team1.HMS.Model.Food;
import com.adbms.team1.HMS.Model.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory,Integer> {

    @Query(value="call hoteldb.getAllFoodCategory();", nativeQuery=true)
    List<FoodCategory> getAllFoodCategory();
}
