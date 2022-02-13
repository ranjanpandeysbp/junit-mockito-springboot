package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;

    static Double num1;
    static Double num2;
    static Double num3;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
        num1 = 3.5;
        num2 = 3.5;
        num3 = 3.5;
    }

    @BeforeEach
    void init(){
        System.out.println("Before Each");
    }

    @AfterEach
    void destroy(){
        System.out.println("After Each");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After All");
        num1 = null;
        num2 = null;
        num3 = null;
    }

    @Test
    @DisplayName("Test Addition Success Scenario")
    void testAddFunction_Success(){
        System.out.println("Test Addition Success Scenario");
        Double result = calculatorController.add(num1, num2, num3);
        //Expected is 7.0
        //Always perform assertion
        assertEquals(7.0, result);
    }

    @Test
    //@Disabled
    @DisplayName("Test Addition Failure Scenario")
    void testAddFunction_Failure(){
        System.out.println("Test Addition Failure Scenario");
        Double result = calculatorController.add(num1 - 0.5, num2, num3);
        //Deliberately give wrong Expected is 7.0
        //Always perform assertion
        Assertions.assertNotEquals(7.0, result);
    }

    @Test
    @DisplayName("Test Substraction for num1>num2 Scenario")
    public void testSubFunction_num1_gt_num2(){
        Double result = calculatorController.substract(num1+1, num2);
        assertEquals(1.0, result);
    }

    @Test
    @DisplayName("Test Substraction for num1>num2 Scenario")
    public void testSubFunction_num1_lt_num2(){
        Double result = calculatorController.substract(num1, num2+1);
        assertEquals(1.0, result);
    }

    @Test
    @DisplayName("Test Multiplication")
    void testMultiply(){

        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setNum1(num1);
        calculatorDTO.setNum2(num2);
        calculatorDTO.setNum3(num3);
        calculatorDTO.setNum4(2.0);

        ResponseEntity<Double> responseEntity = calculatorController.multiply(calculatorDTO);
        assertEquals(85.75, responseEntity.getBody());
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue(), "Expecting the status as OK");
    }
}
