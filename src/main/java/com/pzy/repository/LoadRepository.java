package com.pzy.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Load;
public interface LoadRepository extends PagingAndSortingRepository<Load, Long>,JpaSpecificationExecutor<Load>{
    
}

