package com.pzy.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Car;
public interface CarRepository extends PagingAndSortingRepository<Car, Long>,JpaSpecificationExecutor<Car>{
    
}

