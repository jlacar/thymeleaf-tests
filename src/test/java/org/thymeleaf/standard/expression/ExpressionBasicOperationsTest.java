package org.thymeleaf.standard.expression;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
@SuppressWarnings("unused")
public class ExpressionBasicOperationsTest extends BaseStandardDialectExpressionTest {

    @Test
    @Parameters(method = "arithmetic_params")
    public void arithmetic_expression_evaluation(String expr, String expected) {
        assertThat(eval(expr), is(expected));
    }
    
    private Object arithmetic_params() {
        return new Object[][] { 
            { "23 + 43 + 1", "67" }, 
            { "1 + 2 * 3", "7" }, 
        };
    }
    
    @Test
    @Parameters(method = "parentheses_params")
    public void parentheses_honored(String expr, String expected) {
        assertThat(eval(expr), is(expected));
    }
    
    private Object parentheses_params() {
        return new Object[][] {
            { "1 + 2 * 3 * 6 / 4 + 2", "12" },
            { "((1 + 2) * 3) * 6 / (4 + 2)", "9" },
            
            { "-3 -4 - -5 + -10", "-12" },
            { "-3 -4 - (-5 + -10)", "8" },
        };
    }
    
    @Test
    @Parameters(method = "trueFalse_params, yesNo_params, intAsBool_params")
    public void ternary_operator_recognizes_different_values_as_boolean(String expr, String expected) {
        assertThat(eval(expr), is(expected));
    }
    
    private Object trueFalse_params() {
        return new Object[][] {
            { "${true} ? 'T' : 'F'", "T" },
            { "${false} ? 'T' : 'F'", "F" },     

            { "'true' ? 'T' : 'F'", "T" },
            { "'false' ? 'T' : 'F'", "F" },

            { "'True' ? 'T' : 'F'", "T" },
            { "'False' ? 'T' : 'F'", "F" },

            { "'tRuE' ? 'T' : 'F'", "T" },
            { "'FAlsE' ? 'T' : 'F'", "F" },
            
            { "'TRUE' ? 'T' : 'F'", "T" },
            { "'FALSE' ? 'T' : 'F'", "F" },
        };
    }

    private Object yesNo_params() {
        return new Object[][] {
            { "'yes' ? 'T' : 'F'", "T" },
            { "'no' ? 'T' : 'F'", "F" },
        
            { "'Yes' ? 'T' : 'F'", "T" },
            { "'No' ? 'T' : 'F'", "F" },
            
            { "'YeS' ? 'T' : 'F'", "T" },
            { "'nO' ? 'T' : 'F'", "F" },
    
            { "'YES' ? 'T' : 'F'", "T" },
            { "'NO' ? 'T' : 'F'", "F" },
        };
    }
    
    private Object intAsBool_params() {
        return new Object[][] {
            { "1 ? 'T' : 'F'", "T" },
            { "0 ? 'T' : 'F'", "F" },
        };
    }
    
    @Test
    @Parameters(method = "nonBoolean_params")
    public void ternary_operator_treats_value_as_true_when_not_recognized_as_boolean(String expr, String expected) {
        assertThat(eval(expr), is(expected));
    }
      
    private Object nonBoolean_params() {
        return new Object[][] {
            { "'T' ? 'T' : 'F'", "T" },
            { "'F' ? 'T' : 'F'", "T" },

            { "'Y' ? 'T' : 'F'", "T" },
            { "'N' ? 'T' : 'F'", "T" },

            { "5 ? 'T' : 'F'", "T" },
            { "-5 ? 'T' : 'F'", "T" },
            { "-1 ? 'T' : 'F'", "T" },
            { "103 ? 'T' : 'F'", "T" },
        };
    }
    
    @Test
    @Parameters(method = "stringConcat_params")
    public void string_concatenation_follows_Java_evaluation_rules(String expr, String expected) {
        assertThat(eval(expr), is(expected));
    }
    
    private Object stringConcat_params() {
        return new Object[][] {
            { "'.' + 3 + 2", ".32" },
            { "3 + '.' + 2", "3.2" },
            { "3 + 2 + '.' + 4 + 1", "5.41" },
            
            { "'Number ' + 3 + 2 + '.'", "Number 32." },
            { "'Number ' + (3 + 2) + '.'", "Number 5." },
            
            { "'2' + '1'", "21" },
            { "'2' + 1", "21" },
            { "2 + '1'", "21" },
        };
    }
     
    @Test
    @Parameters(method = "relationalOperators_params, logicalOperators_params")
    public void conditional_operations(String expr, String expected) {
        assertThat(eval(expr), is(expected));
    }
    
    private Object relationalOperators_params() {
        return new Object[][] {
            { "'x' == 'x'", "true" },
            { "'4' == 4", "true" },
            { "'4' == 2 + 2", "true"},

            { "'x' == 'X'", "false" },
            { "'X' == 'X'", "true" },
            
            { "'z' == 'y' + 1", "false" },
            { "'y1' == 'y' + 1", "true" },
            
            { "'x' EQ 'x'", "true" },
            { "'4' eq 4", "true" },
            
            { "'x' != 'x'", "false" },
            { "'4' != 4", "false" },
            
            { "'x' NEQ 'x'", "false" },
            { "'4' neq 4", "false" },
            
            { "5 >= 6", "false" },
            { "5 >= 5", "true" },
            { "5 >= 4", "true" },
            
            { "5 ge 6", "false" },
            { "5 ge 5", "true" },
            { "5 ge 4", "true" },

            { "5 GE 6", "false" },
            { "5 GE 5", "true" },
            { "5 GE 4", "true" },
            
            { "5 > 6", "false" },
            { "5 > 5", "false" },
            { "5 > 4", "true" },
            
            { "5 gt 6", "false" },
            { "5 gt 5", "false" },
            { "5 gt 4", "true" },

            { "5 GT 6", "false" },
            { "5 GT 5", "false" },
            { "5 GT 4", "true" },
            
            { "5 <= 6", "true" },
            { "5 <= 5", "true" },
            { "5 <= 4", "false" },
            
            { "5 le 6", "true" },
            { "5 le 5", "true" },
            { "5 le 4", "false" },
            
            { "5 LE 6", "true" },
            { "5 LE 5", "true" },
            { "5 LE 4", "false" },

            { "5 < 6", "true" },
            { "5 < 5", "false" },
            { "5 < 4", "false" },
            
            { "5 lt 6", "true" },
            { "5 lt 5", "false" },
            { "5 lt 4", "false" },
            
            { "5 LT 6", "true" },
            { "5 LT 5", "false" },
            { "5 LT 4", "false" },
        };
    }

    private Object logicalOperators_params() {
        return new Object[][] {
            { "${false} and ${false}", "false" },
            { "${false} and ${true}", "false" },
            { "${true} and ${false}", "false" },
            { "${true} and ${true}", "true" },

            { "${false} AND ${false}", "false" },
            { "${false} AND ${true}", "false" },
            { "${true} AND ${false}", "false" },
            { "${true} AND ${true}", "true" },
            
            { "${false} or ${false}", "false" },
            { "${false} or ${true}", "true" },
            { "${true} or ${false}", "true" },
            { "${true} or ${true}", "true" },

            { "${false} OR ${false}", "false" },
            { "${false} OR ${true}", "true" },
            { "${true} OR ${false}", "true" },
            { "${true} OR ${true}", "true" },

            { "${!true}", "false" },
            { "${!false}", "true" },
        };
    }

}
