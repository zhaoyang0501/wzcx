
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
import com.pzy.repository.AccidentRepository;

@Service
public class AccidentService {
     @Autowired
     private AccidentRepository bccidentRepository;
     
     public List<Accident> findAll() {
         return (List<Accident>) bccidentRepository.findAll();
     }
     
     public Page<Accident> findAll(final int pageNumber, final int pageSize,final String no){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
        
         Specification<Accident> spec = new Specification<Accident>() {
              public Predicate toPredicate(Root<Accident> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (no != null) {
                   predicate.getExpressions().add(cb.like(root.get("no").as(String.class), "%"+no+"%"));
              }
              return predicate;
              }
         };
         Page<Accident> result = (Page<Accident>) bccidentRepository.findAll(spec, pageRequest);
         return result;
     	}
		public void delete(Long id){
			bccidentRepository.delete(id);
		}
		public Accident find(Long id){
			  return bccidentRepository.findOne(id);
		}
		public void save(Accident bccident){
			bccidentRepository.save(bccident);
		}
}