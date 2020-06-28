package com.virtualpairprogrammers.templates;

import com.virtualpairprogrammers.LoanApplication;

import java.math.BigDecimal;

public class LoanApplicationTemplate {

    public static LoanApplication constructDefault(){
        LoanApplication loan = new LoanApplication();
        loan.setId(1);
        loan.setRepayment(new BigDecimal(110));
        loan.setApproved(true);
        loan.setName("Test 1 Year");
        loan.setPrincipal(1200);
        loan.setTermInMonths(12);

        return loan;
    }
}
