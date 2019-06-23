package com.usecase.personalloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.personalloan.dto.ResponseDto;
import com.usecase.personalloan.exception.OXBankingException;
import com.usecase.personalloan.model.Loan;
import com.usecase.personalloan.service.ILoanService;

@RestController
@RequestMapping("/OXBanking")
public class OXBankingController {

	@Autowired
	private ILoanService loanService;
	@PostMapping("/createloan")
	public ResponseEntity<ResponseDto>  createLoan(@RequestBody Loan loan){
		return loanService.createLoan(loan);
		
	}
	@PutMapping("/approve")
	public ResponseEntity<ResponseDto> approveLoan(@RequestParam Long accountNumber) throws OXBankingException{
		return loanService.approveLoan(accountNumber);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteLoan(@RequestParam Long accountNumber){
		return loanService.deleteLoan(accountNumber);
	}
}
