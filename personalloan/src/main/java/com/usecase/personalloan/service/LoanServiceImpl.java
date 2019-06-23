package com.usecase.personalloan.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.usecase.personalloan.dto.ResponseDto;
import com.usecase.personalloan.exception.OXBankingException;
import com.usecase.personalloan.model.Customer;
import com.usecase.personalloan.model.Loan;
import com.usecase.personalloan.repository.ICustomerRepository;
import com.usecase.personalloan.repository.ILoanRepository;

@Service
public class LoanServiceImpl implements ILoanService {

	@Autowired
	private ILoanRepository loanRepository;
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public ResponseEntity<ResponseDto> createLoan(Loan loan) {
		
		loanRepository.save(loan);
		
		return new ResponseEntity<ResponseDto>(new ResponseDto("Loan created for customer sucessfully"),HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseDto> approveLoan(Long accountNumber) throws OXBankingException{
		Loan loan=loanRepository.getOne(accountNumber);
		Long appliedCustomerId=loan.getCustomerId();
		Customer appliedCustomer=customerRepository.getOne(appliedCustomerId);
		if(appliedCustomer.getCreditScore()>900) {
			if(appliedCustomer.getWorkExp()>2) {
				if(Period.between(appliedCustomer.getDob(),LocalDate.now()).getYears()>24) {
					loan.setLoanStatus("approved");
				}
				else {
					throw new OXBankingException("age should be greater than 24");
				}
			}
			else throw new OXBankingException("work experience is less");
		}
		else {
			throw new OXBankingException("Credit score is less");
		}
		return new ResponseEntity<ResponseDto>(new ResponseDto("Loan approved for customer sucessfully"),HttpStatus.OK);
		
	}

	@Override
	public ResponseEntity<ResponseDto> deleteLoan(Long accountNumber) {
		Loan loan=loanRepository.getOne(accountNumber);
		if(!loan.getLoanStatus().equalsIgnoreCase("approved")){
			loanRepository.delete(loan);
		}
		
		return new ResponseEntity<ResponseDto>(new ResponseDto("Loan deleted sucessfully"),HttpStatus.OK);
	}

	
	

}
