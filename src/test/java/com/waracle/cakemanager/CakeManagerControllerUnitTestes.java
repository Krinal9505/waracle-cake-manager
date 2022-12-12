package com.waracle.cakemanager;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.waracle.cakemanager.beans.Cake;
import com.waracle.cakemanager.controllers.CakeManagerController;
import com.waracle.cakemanager.services.CakeManagerService;

@SpringBootTest(classes = {CakeManagerControllerUnitTestes.class})
public class CakeManagerControllerUnitTestes 
{
	@Mock
	CakeManagerService cakeManagerService; 
	
	@InjectMocks
	CakeManagerController cakeManagerCon;

	@Test
	public void test_getAllCake()
	{
		List<Cake> cakes = new ArrayList<>();
		cakes.add(new Cake("Red velvet","strawberry","yum"));
		cakes.add(new Cake("Chocolate","milk chocolate","delicious"));
		
		when(cakeManagerService.getAllCakes()).thenReturn(cakes);
		assertEquals(cakes.size(),cakeManagerCon.getAllCakes().size());
	}
	
	@Test
	public void test_addCake()throws Exception
	{
		Cake cake = new Cake("Red velvet","strawberry","yum");
		
		when(cakeManagerService.addCake(cake)).thenReturn(cake);
		
		ResponseEntity<Cake> res = cakeManagerCon.addCake(cake);
		assertEquals(res.getStatusCode(), HttpStatus.CREATED);
	}
	
	@Test
	public void test_updateCakeByZeroId()
	{
		Cake cake = new Cake("Red velvet","strawberry","yum");
		ResponseEntity<Cake> res = cakeManagerCon.updateCake(cake, 0);
		assertEquals(res.getStatusCode(), HttpStatus.BAD_REQUEST);
		
	}
	
	@Test
	public void test_updateCake()
	{
		Cake cake = new Cake("Red velvet","strawberry","yum");

		when(cakeManagerService.getCakeById(1)).thenReturn(cake);
		
		ResponseEntity<Cake> res = cakeManagerCon.updateCake(cake, 1);
		assertEquals(res.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void test_deleteCakeByZeroId()
	{
		ResponseEntity<Cake> res = cakeManagerCon.deleteCake(0);
		assertEquals(res.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
}
