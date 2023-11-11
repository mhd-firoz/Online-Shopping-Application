package com.test.mongo.db.springbootmongodb.controller;

import java.util.List;

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

import com.test.mongo.db.springbootmongodb.model.Expense;
import com.test.mongo.db.springbootmongodb.service.ExpenseService;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
	
	private ExpenseService expenseService;
	
	
	public ExpenseController(ExpenseService expenseService) {
		super();
		this.expenseService = expenseService;
	}


	@PostMapping()
	public ResponseEntity<Expense> addExpense(@RequestBody Expense exp) {
		
		return new ResponseEntity<Expense>(expenseService.addExpense(exp),HttpStatus.CREATED);

	}

	@PutMapping()
	  public ResponseEntity<Object> updateExpense(@RequestBody Expense exp) {
		  
		  expenseService.updateExpense(exp);
		  return new ResponseEntity<Object>(HttpStatus.OK);
				  
				  
	  
	  }
	  
	  @GetMapping()
	  public ResponseEntity<List<Expense>> getAllExpense() {
		  
		  return new ResponseEntity<List<Expense>>(expenseService.getAllExpense(), HttpStatus.OK);
	  
	  }
	  
	  @GetMapping("/{name}")
	  public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
		  
		 return new ResponseEntity<Expense>(expenseService.getExpenseByName(name), HttpStatus.OK);
	  
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<Object> deleteExpense(@PathVariable  String id) {
		  
		  expenseService.deleteExpense(id);
		  
		  return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	  
	  }
	 

}
