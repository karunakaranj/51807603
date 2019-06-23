package com.usecase.personalloan.service;

import org.springframework.http.ResponseEntity;

import com.usecase.personalloan.dto.ResponseDto;
import com.usecase.personalloan.exception.OXBankingException;
import com.usecase.personalloan.model.Loan;


public interface ILoanService {

	public ResponseEntity<ResponseDto> createLoan(Loan loan);

	public ResponseEntity<ResponseDto> approveLoan(Long accountNumber) throws OXBankingException;

	public ResponseEntity<ResponseDto> deleteLoan(Long accountNumber);

}
