package com.bt.api.controllers;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.api.models.Statement;
import com.bt.api.services.StatementService;

@RestController
@CrossOrigin
@RequestMapping("/statement")
public class StatementApi {

	@Autowired
	private StatementService statementService;
	
	@GetMapping("/{accountNumber}/currentMonth")
	public ResponseEntity<Statement> getCurrentMonthStatement(@PathVariable("accountNumber")Long accountNumber){
		LocalDate today = LocalDate.now();
		LocalDate start = LocalDate.of(today.getYear(),today.getMonth(),1);
		LocalDate end = start.with(TemporalAdjusters.lastDayOfMonth());
		return ResponseEntity.ok(statementService.generateStatement(accountNumber, start, end));
	}
	
	@GetMapping("/{accountNumber}/currentYear")
	public ResponseEntity<Statement> getCurrentYearStatement(@PathVariable("accountNumber")Long accountNumber){
		LocalDate today = LocalDate.now();
		LocalDate start = LocalDate.of(today.getYear(),Month.JANUARY,1);
		LocalDate end = start.with(TemporalAdjusters.lastDayOfYear());
		return ResponseEntity.ok(statementService.generateStatement(accountNumber, start, end));
	}
	
	@GetMapping("/{accountNumber}/{year}")
	public ResponseEntity<Statement> getAnnualStatement(@PathVariable("accountNumber")Long accountNumber,@PathVariable("year")int year){
		LocalDate start = LocalDate.of(year,Month.JANUARY,1);
		LocalDate end = start.with(TemporalAdjusters.lastDayOfYear());
		return ResponseEntity.ok(statementService.generateStatement(accountNumber, start, end));
	}
	
	@GetMapping("/{accountNumber}/{year}/{month}")
	public ResponseEntity<Statement> getMonthlyStatement(@PathVariable("accountNumber")Long accountNumber,@PathVariable("year")int year,@PathVariable("month")Month month){
		LocalDate start = LocalDate.of(year,month,1);
		LocalDate end = start.with(TemporalAdjusters.lastDayOfMonth());
		return ResponseEntity.ok(statementService.generateStatement(accountNumber, start, end));
	}
}
