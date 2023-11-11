package com.test.mongo.db.springbootmongodb.service;

import java.util.List;

import com.test.mongo.db.springbootmongodb.model.Expense;


public interface ExpenseService {
	
	public Expense addExpense(Expense exp) ;
	public void updateExpense(Expense exp);
	public List<Expense> getAllExpense() ;
	public Expense getExpenseByName(String name) ;
	public void deleteExpense(String id) ;


}
