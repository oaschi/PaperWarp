package io.github.oaschi.paperwarp.dao;

import io.github.oaschi.paperwarp.PaperWarp;
import io.github.oaschi.paperwarp.domain.AbstractWarp;

import java.util.List;

import com.avaje.ebean.EbeanServer;

public abstract class AbstractWarpDao<T extends AbstractWarp> implements Dao<T>{

	private PaperWarp plugin;
	
	private final Class<T> typeParameterClass;
	
	public AbstractWarpDao(Class<T> typeParameterClass){
		this.typeParameterClass = typeParameterClass;
		this.plugin = PaperWarp.plugin;
	}
	
	/**
	 * Saves an entity into the database.
	 * 
	 * @return False if an Exception occured while saving the entity.
	 */
	@Override
	public boolean save(T entity) {
		try{
			plugin.getDatabase().save(entity);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Removes an entity from the database.
	 * 
	 * @return False if an Exception occured while deleting the entity.
	 */
	@Override
	public boolean delete(T entity) {
		try{
			plugin.getDatabase().delete(entity);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Returns a List of all entities of the generic
	 * datatype typeParameterClass a.k.a. T in the database.
	 */
	@Override
	public List<T> findAll() {
		return plugin.getDatabase().find(typeParameterClass).findList();
	}
	
	/**
	 * Returns a unique entity of the database
	 */
	@Override
	public T findById(int id) {
		return plugin.getDatabase().find(typeParameterClass, id);
	}
	
	/**
	 * Returns the database instance.
	 */
	public EbeanServer getDatabase(){
		return plugin.getDatabase();
	}
	
}
