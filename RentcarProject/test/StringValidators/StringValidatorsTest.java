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
    
    static StringValidators validator;
    
    public void iniciar(){
        validator = new StringValidators();
    }
    
    @Test
    public void cpfNumerictest(){
        
        iniciar();
        
        var res = validator.isNumeric("012345678901");
        
        assertTrue(res);
        
    }
    
    @Test
    public void cpfWithCharactersNotNumerictest(){
        
        iniciar();

        var res = validator.isNumeric("01234s67890#");
        
        assertFalse(res);
    }
}
