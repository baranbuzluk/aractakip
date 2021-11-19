package com.ldselektronik.window.product.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ldselektronik.window.product.data.entity.ProductEntity;
import com.ldselektronik.window.product.data.repository.ProductRepository;

/**
 * @author Baran
 *
 */
@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository repository;

	@Autowired
	Logger logger;

	public List<ProductEntity> getAllProductEntities() {
		return repository.findAll();

	}

	/**
	 * If there is the object has same <code>id</code> value in the table, The
	 * object is not saved to the table but is updated.
	 * 
	 */
	public void saveEntity(ProductEntity entity) {
		if (entity == null) {
			logger.log(Level.WARNING, "Error ProductEntiy object is null! - The object was not saved.");
			return;
		}
		repository.save(entity);
	}

	/**
	 * @param id - primary key
	 * @return ProductEntiy<br>
	 *         <code>null</code> - if given id has not
	 */
	public ProductEntity findEntityById(int id) {
		Optional<ProductEntity> optional = repository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

}
