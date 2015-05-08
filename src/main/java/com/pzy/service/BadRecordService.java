
package com.pzy.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pzy.entity.BadRecord;
import com.pzy.entity.Car;
import com.pzy.repository.BadRecordRepository;

@Service
public class BadRecordService {
     @Autowired
     private BadRecordRepository badRecordRepository;
     
     public List<BadRecord> findAll() {
         return (List<BadRecord>) badRecordRepository.findAll();
     }
     
     public Page<BadRecord> findAll(final int pageNumber, final int pageSize,final Car car){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
        
         Specification<BadRecord> spec = new Specification<BadRecord>() {
              public Predicate toPredicate(Root<BadRecord> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (car != null) {
                   predicate.getExpressions().add(cb.equal(root.get("car").as(Car.class), car));
              }
              return predicate;
              }
         };
         Page<BadRecord> result = (Page<BadRecord>) badRecordRepository.findAll(spec, pageRequest);
         return result;
     	}
		public void delete(Long id){
			badRecordRepository.delete(id);
		}
		public BadRecord find(Long id){
			  return badRecordRepository.findOne(id);
		}
		public void save(BadRecord badRecord){
			badRecordRepository.save(badRecord);
		}
}