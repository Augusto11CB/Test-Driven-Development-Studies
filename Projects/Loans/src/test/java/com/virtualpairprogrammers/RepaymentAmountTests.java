package com.virtualpairprogrammers;

import com.virtualpairprogrammers.templates.LoanApplicationTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RepaymentAmountTests {

    @Mock
    private LoanRepository data;

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private RestTemplate restTemplate;

    @Spy
    private LoanApplication loan;

    private LoanCalculatorController controller;

    @BeforeEach
    void init() {
        data = mock(LoanRepository.class);
        mailSender = mock(JavaMailSender.class);
        restTemplate = mock(RestTemplate.class);

        controller = new LoanCalculatorController();

        controller.setData(data);
        controller.setMailSender(mailSender);
        controller.setRestTemplate(restTemplate);

        loan = spy(LoanApplicationTemplate.constructDefault());

    }

    @Test
    public void test1YearLoanWholePounds() {
//        when(restTemplate.postForLocation(any(),any())).thenReturn(new URI("loan-repayment-amount"));
//        when(loan.getInterestRate()).thenReturn(new BigDecimal(10)); -- It don't works. In order to get the expected value we must use the doReturn operation
        doReturn(new BigDecimal(10)).when(loan).getInterestRate();

        controller.processNewLoanApplication(loan);

        assertEquals(new BigDecimal(110), loan.getRepayment());
    }


    @Test
    public void test2YearLoanWholePounds() {

        loan.setPrincipal(1200);
        loan.setTermInMonths(24);
        doReturn(new BigDecimal(10)).when(loan).getInterestRate();

        controller.processNewLoanApplication(loan);

        assertEquals(new BigDecimal(60), loan.getRepayment());
    }

    @Test
    public void test5YearLoanWithRounding() {

        loan.setPrincipal(5000);
        loan.setTermInMonths(60);
        doReturn(new BigDecimal(6.5)).when(loan).getInterestRate();

        controller.processNewLoanApplication(loan);

        assertEquals(new BigDecimal(111), loan.getRepayment());
    }
}
