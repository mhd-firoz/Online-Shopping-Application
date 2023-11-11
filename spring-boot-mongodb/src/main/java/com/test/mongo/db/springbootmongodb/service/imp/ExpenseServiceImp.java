package com.test.mongo.db.springbootmongodb.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.mongo.db.springbootmongodb.model.Expense;
import com.test.mongo.db.springbootmongodb.repo.ExpenseRepository;
import com.test.mongo.db.springbootmongodb.service.ExpenseService;

@Service
public class ExpenseServiceImp implements ExpenseService{
	
	private ExpenseRepository expenseRepository;
	

	public ExpenseServiceImp(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}


	@Override
	public Expense addExpense(Expense exp) {
		// TODO Auto-generated method stub
		return expenseRepository.insert(exp);
	}


	@Override
	public void updateExpense(Expense exp) {
		// TODO Auto-generated method stub
		
		Expense updateExpense = expenseRepository.findById(exp.getId()).orElseThrow(() -> 
				new RuntimeException(String.format("Cannot Find Expense by ID %S",exp.getId())));
		
		updateExpense.setExpenseName(exp.getExpenseName());
		updateExpense.setExpenseCategory(exp.getExpenseCategory());
		updateExpense.setExpenseAmount(exp.getExpenseAmount());
		
		expenseRepository.save(updateExpense);
			
		
	}


	@Override
	public List<Expense> getAllExpense() {
		// TODO Auto-generated method stub
		return expenseRepository.findAll();
				
	}


	@Override
	public Expense getExpenseByName(String name) {
		// TODO Auto-generated method stub
		
		return expenseRepository.findByName(name).orElseThrow(() -> 
			new RuntimeException(String.format("Cannot find Expense by name %S", name)));
		
	}


	@Override
	public void deleteExpense(String id) {
		// TODO Auto-generated method stub
		
		Optional<Expense> deleteExpenseId = expenseRepository.findById(id);
		
		if(deleteExpenseId.isPresent())
		{
			expenseRepository.deleteById(id);
		}
		else
		{
			throw new RuntimeException(String.format("Cannot find Expense by Id %S", id));
		}
		

		
	}
	




	

}
