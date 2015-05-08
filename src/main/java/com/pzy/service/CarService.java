
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
import com.pzy.repository.CarRepository;
import com.pzy.repository.CategoryRepository;

@Service
public class CarService {
     @Autowired
     private CarRepository carRepository;
     
     public List<Car> findAll() {
         return (List<Car>) carRepository.findAll();
     }
     
     public Page<Car> findAll(final int pageNumber, final int pageSize,final String no){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
        
         Specification<Car> spec = new Specification<Car>() {
              public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (no != null) {
                   predicate.getExpressions().add(cb.like(root.get("no").as(String.class), no+"%"));
              }
              return predicate;
              }
         };
         Page<Car> result = (Page<Car>) carRepository.findAll(spec, pageRequest);
         return result;
     	}
		public void delete(String id){
			carRepository.delete(id);
		}
		public Car find(String id){
			if(id==null)
				return null;
			else 
			  return carRepository.findOne(id);
		}
		public void save(Car car){
			carRepository.save(car);
		}
}