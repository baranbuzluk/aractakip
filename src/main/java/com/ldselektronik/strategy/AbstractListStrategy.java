package com.ldselektronik.strategy;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Baran
 *
 * @param <T> - Type of repository to use to list items
 * @param <E> - Type of items to list
 */
public abstract class AbstractListStrategy<T extends JpaRepository<?, ?>, E> {

	@Autowired
	protected T repository;

	@Autowired
	protected Logger logger;
	
	public abstract List<E> getListByStrategy(E arg);

}
