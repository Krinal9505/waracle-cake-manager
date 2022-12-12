package com.waracle.cakemanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.waracle.cakemanager.beans.Cake;
import com.waracle.cakemanager.repositories.CakeManagerRepository;

@Component
@Service
public class CakeManagerService 
{
	@Autowired
	CakeManagerRepository cakeManagerRepository;
	
	public List<Cake> getAllCakes()
	{
		return cakeManagerRepository.findAll();
	}
	
	public Cake addCake(Cake cake)
	{	
		return cakeManagerRepository.save(cake);
	}
	
	public Cake updateCake(Cake cake)
	{
		return cakeManagerRepository.save(cake);
	}
	
	public Cake getCakeById(int id)
	{
		return cakeManagerRepository.findById(id).get();
	}
	
	public void deleteCake(Cake cake)
	{
		cakeManagerRepository.delete(cake);
	}
}
