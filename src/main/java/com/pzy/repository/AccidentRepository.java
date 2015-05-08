package com.pzy.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Accident;
import com.pzy.entity.BadRecord;
public interface AccidentRepository extends PagingAndSortingRepository<Accident, Long>,JpaSpecificationExecutor<Accident>{
    
}

