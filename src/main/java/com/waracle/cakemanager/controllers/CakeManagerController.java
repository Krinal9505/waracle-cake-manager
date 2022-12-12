package com.waracle.cakemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waracle.cakemanager.beans.Cake;	
import com.waracle.cakemanager.services.CakeManagerService;

@RestController
@RequestMapping("/cakemanager")
public class CakeManagerController 
{
	@Autowired
	CakeManagerService cakeManagerService;
	
	/**
	 * This method return list of cakes
	 * @return
	 */
	@GetMapping("/getCakes")
	public List<Cake> getAllCakes()
	{
		return cakeManagerService.getAllCakes();
	}
	
	/**
	 * This method will take cake object and return added cake object,
	 * if anything wrong with addition then it will throw exception and show bad request message to client
	 * @param cake
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/addCake")
	public ResponseEntity<Cake> addCake(@RequestBody Cake cake)throws Exception
	{
		try
		{
			return new ResponseEntity<Cake>(cakeManagerService.addCake(cake), HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * This method take cake object and cake id as a parameters and get existing cake using id
	 * change the value of existing cake and return the updated cake object
	 * if any conflict in updating the value, method will throw an exception and show bad request to client
	 * @param cake
	 * @param id
	 * @return
	 */
	@PutMapping("/updateCake/{id}")
	public ResponseEntity<Cake> updateCake(@RequestBody Cake cake, @PathVariable(value="id") int id)
	{
		try
		{
			if(id == 0)
			{
				throw new Exception();
			}
			
			Cake existingCake = cakeManagerService.getCakeById(id);
			existingCake.setName(cake.getName());
			existingCake.setFlavour(cake.getFlavour());
			existingCake.setDescription(cake.getDescription());
			
			return new ResponseEntity<Cake>(cakeManagerService.updateCake(existingCake), HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * This method take cake id, find existing cake using that id and delete it from the database 
	 * and return OK status to users
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteCake/{id}")
	public ResponseEntity<Cake> deleteCake(@PathVariable(value="id") int id)
	{
		try
		{
			if(id == 0)
			{
				throw  new Exception();
			}
			cakeManagerService.deleteCake(cakeManagerService.getCakeById(id));
			return new ResponseEntity<>(HttpStatus.OK); 
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
