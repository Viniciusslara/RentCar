/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package StringValidators;

import helpers.StringValidators;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vinicius
 */
public class StringValidatorsTest {
    
    static StringValidators validator = new StringValidators();
  
    
    @Test
    public void isCPFNumerictest(){
        
        var res = validator.isNumeric("012345678901");
        
        assertTrue(res);
        
    }
    
    @Test
    public void isCPFWithCharactersNotNumerictest(){
        
        var res = validator.isNumeric("01234s67890#");
        
        assertFalse(res);
    }
    
    @Test
    public void isCPFValidotest(){    
        
        var res = validator.isCPFValido("88945004033");
        
        assertTrue(res);
        
    }
    
    @Test
    public void isCPFInvalidotest(){    
        
        var res = validator.isCPFValido("00000000000");
        
        assertFalse(res);
        
    }
    
    @Test
    public void isCPFWithElevenDigitstest(){
        
        var res = validator.isCPFValido("88945004033");
        
        assertTrue(res); 
    }
    
    @Test
    public void isCPFWithMoreElevenDigitstest(){
        
        var res = validator.isCPFValido("8894500403390");
        
        assertFalse(res); 
    }
    
    @Test
    public void isCPFWithLessElevenDigitstest(){
        
        var res = validator.isCPFValido("889450040");
        
        assertFalse(res); 
    }
    
    @Test
    public void isCPFNulltest(){
        
        var res = validator.isCPFValido(null);
        
        assertFalse(res); 
        
    }
    
    @Test
    public void isDateInvalidtest(){
        
        var res = validator.isDateValid("30/03/2024");
        
        assertFalse(res);
       
    }
    
    @Test
    public void isDateValidtest(){
        
        var res = validator.isDateValid("14/04/1999");
        
        assertTrue(res);
    }
    
    @Test
    public void is18YearsOldtest(){
        
        var res = validator.is18YearsOld("14/04/2005");
        
        assertTrue(res);
    }
    
    @Test
    public void isMore18YearsOldtest(){
        
        var res = validator.is18YearsOld("14/04/1999");
        
        assertTrue(res);
    }
   
}
