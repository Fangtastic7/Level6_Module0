package _06_payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
        //given
    	int a = 8;
    	double b = 100.0;
    	double expected = 800;
        //when
    	double actual = payroll.calculatePaycheck(b, a);
        //then
    	assertEquals(expected, actual);
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given
    	int m = 1000;
    	double expected = 575;
        //when
    	double actual = payroll.calculateMileageReimbursement(m);
        //then
    	assertEquals(expected, actual);
    }

    @Test
    void itShouldCreateOfferLetter() {
        //given
        String a = "Bob";
        double b = 8;
        String expected = "Hello Bob, We are pleased to offer you an hourly wage of " + b;
        //when
        String actual = payroll.createOfferLetter(a, b);
        //then
        assertEquals(expected, actual);
    }

}