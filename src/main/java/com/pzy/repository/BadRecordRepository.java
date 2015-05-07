package com.pzy.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.BadRecord;
public interface BadRecordRepository extends PagingAndSortingRepository<BadRecord, Long>,JpaSpecificationExecutor<BadRecord>{
    
}

