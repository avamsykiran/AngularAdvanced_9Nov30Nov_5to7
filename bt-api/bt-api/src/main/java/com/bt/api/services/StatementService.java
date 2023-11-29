package com.bt.api.services;

import java.time.LocalDate;

import com.bt.api.models.Statement;

public interface StatementService {
	Statement generateStatement(Long accountNumber,LocalDate start,LocalDate end);
}
