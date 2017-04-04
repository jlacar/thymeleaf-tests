/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2017, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class NumberUtilsFormatTest {
    
    private static final Locale DEFAULT_LOCALE = Locale.US;

    @Test
    @Parameters(method = "notPadded_params, zeroPadded_params")
    public void minIntegerDigits_controls_zero_padding(Number target, Integer minIntegerDigits, String expectedPattern) {
        String expected = expectedValue(target, expectedPattern);
        
        assertThat(NumberUtils.format(target, minIntegerDigits, DEFAULT_LOCALE), is(expected));
    }
    
    /**
     * Provides a reference format value for the given target number based on the 
     * given DecimalFormat pattern. The reference value is created using 
     * Locale.US as the default locale.
     * <p>
     * The value returned gives a baseline for comparison with the output of the 
     * format() method being tested.
     * 
     * @param target the number to format 
     * @param pattern the DecimalFormat pattern to use in formatting the number
     * @return the formatted number string
     */
    private String expectedValue(Number target, String pattern) {
        DecimalFormat fmt = (DecimalFormat) NumberFormat.getNumberInstance(DEFAULT_LOCALE);
        fmt.applyPattern(pattern);
        return fmt.format(target);
    }
        
    /* 
     * The parameter methods below return arrays of parameters
     * that will be passed to the parameterized test. Each set
     * of parameters consists of the following:
     * 
     * {0} number to format
     * {1} minIntegerDigits value
     * {2} DecimalFormat pattern for reference format value 
     */
    
    @SuppressWarnings("unused")
    private Object notPadded_params() {        

        final Integer minIntegerDigits = new Integer(0);
        final String expectedPattern = "0";
        
        return new Object[][] {
            {new Integer(0), minIntegerDigits, expectedPattern},
            {new Integer(12345), minIntegerDigits, expectedPattern},
            {new Integer(-12345), minIntegerDigits, expectedPattern},

            {new Double(0), minIntegerDigits, expectedPattern},
            {new Double(12345.1), minIntegerDigits, expectedPattern},
            {new Double(-12345.1), minIntegerDigits, expectedPattern},
        };
    }    

    @SuppressWarnings("unused")
    private Object zeroPadded_params() {
        
        final Integer minIntegerDigits = new Integer(8);
        final String expectedPattern = "00000000";
        
        return new Object[][] {            
            {new Integer(0), minIntegerDigits, expectedPattern},
            {new Integer(12345), minIntegerDigits, expectedPattern},
            {new Integer(-12345), minIntegerDigits, expectedPattern},

            {new Double(0), minIntegerDigits, expectedPattern},
            {new Double(12345.1), minIntegerDigits, expectedPattern},
            {new Double(-12345.1), minIntegerDigits, expectedPattern},
        };
    }    
    
}
