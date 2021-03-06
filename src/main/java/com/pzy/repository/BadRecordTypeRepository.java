package com.pzy.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.BadRecordType;
public interface BadRecordTypeRepository extends PagingAndSortingRepository<BadRecordType, Long>,JpaSpecificationExecutor<BadRecordType>{
    
}

