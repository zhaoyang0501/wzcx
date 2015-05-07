
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

import com.pzy.entity.Car;
import com.pzy.entity.Category;
import com.pzy.entity.Load;
import com.pzy.repository.CarRepository;
import com.pzy.repository.CategoryRepository;
import com.pzy.repository.LoadRepository;

@Service
public class LoadService {
     @Autowired
     private LoadRepository loadRepository;
     
     public List<Load> findAll() {
         return (List<Load>) loadRepository.findAll();
     }
     
     public Page<Load> findAll(final int pageNumber, final int pageSize,final String name){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
        
         Specification<Load> spec = new Specification<Load>() {
              public Predicate toPredicate(Root<Load> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (name != null) {
                   predicate.getExpressions().add(cb.like(root.get("name").as(String.class), "%"+name+"%"));
              }
              return predicate;
              }
         };
         Page<Load> result = (Page<Load>) loadRepository.findAll(spec, pageRequest);
         return result;
     	}
		public void delete(Long id){
			loadRepository.delete(id);
		}
		public Load find(Long id){
			  return loadRepository.findOne(id);
		}
		public void save(Load load){
			loadRepository.save(load);
		}
}