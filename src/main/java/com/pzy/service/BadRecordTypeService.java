
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

import com.pzy.entity.Accident;
import com.pzy.entity.BadRecordType;
import com.pzy.repository.BadRecordTypeRepository;

@Service
public class BadRecordTypeService {
     @Autowired
     private BadRecordTypeRepository badRecordTypeRepository;
     public List<BadRecordType> findAll() {
         return (List<BadRecordType>) badRecordTypeRepository.findAll();
     }
     
     public List<BadRecordType> findBadRecordTypes() {
         return (List<BadRecordType>) badRecordTypeRepository.findAll();
     }
     
     public Page<BadRecordType> findAll(final int pageNumber, final int pageSize,final String name){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
        
         Specification<BadRecordType> spec = new Specification<BadRecordType>() {
              public Predicate toPredicate(Root<BadRecordType> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (name != null) {
                   predicate.getExpressions().add(cb.like(root.get("name").as(String.class), name+"%"));
              }
              return predicate;
              }
         };
         Page<BadRecordType> result = (Page<BadRecordType>) badRecordTypeRepository.findAll(spec, pageRequest);
         return result;
     	}
		public void delete(Long id){
			badRecordTypeRepository.delete(id);
		}
		public BadRecordType findBadRecordType(Long id){
			  return badRecordTypeRepository.findOne(id);
		}
		public void save(BadRecordType badRecordTypeSub){
			badRecordTypeRepository.save(badRecordTypeSub);
		}
}