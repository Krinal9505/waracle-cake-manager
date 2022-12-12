package com.waracle.cakemanager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.waracle.cakemanager.beans.Cake;
import com.waracle.cakemanager.repositories.CakeManagerRepository;
import com.waracle.cakemanager.services.CakeManagerService;

@SpringBootTest(classes = CakeManagerServiceUnitTestes.class)
public class CakeManagerServiceUnitTestes 
{
	@Mock
	CakeManagerRepository cakeManagerRep;
	
	@InjectMocks
	CakeManagerService cakeManagerService;
	
	
	@Test
	public void test_getAllCakes()
	{
		List<Cake> cakes = new ArrayList<>();
		cakes.add(new Cake("Red velvet","strawberry","yum"));
		cakes.add(new Cake("Chocolate","milk chocolate","delicious"));
		
		when(cakeManagerRep.findAll()).thenReturn(cakes);
		assertEquals(cakes.size(), cakeManagerService.getAllCakes().size());
	}
	
	@Test
	public void test_addCake()
	{
		Cake cake = new Cake("Red velvet","strawberry","yum");
		
		when(cakeManagerRep.save(cake)).thenReturn(cake);
		assertEquals(cake, cakeManagerService.addCake(cake));
	}
		
	@Test
	public void test_updateCake()
	{
		Cake cake = new Cake("Red velvet","strawberry","yum");
		
		when(cakeManagerRep.save(cake)).thenReturn(cake);
		assertEquals(cake, cakeManagerService.updateCake(cake));
	}
	
	public void test_getCakeById()
	{
		Cake cake = new Cake("Red v	elvet","strawberry","yum");
		
		when(cakeManagerRep.findById(1).get()).thenReturn(cake);
		assertEquals(cake, cakeManagerService.getCakeById(1));
	}
}
