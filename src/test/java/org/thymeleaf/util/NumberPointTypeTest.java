package org.thymeleaf.util;

import static org.junit.Assert.*;
import static org.thymeleaf.util.NumberPointType.COMMA;
import static org.thymeleaf.util.NumberPointType.DEFAULT;
import static org.thymeleaf.util.NumberPointType.NONE;
import static org.thymeleaf.util.NumberPointType.POINT;
import static org.thymeleaf.util.NumberPointType.WHITESPACE;
import static org.thymeleaf.util.NumberPointType.match;

import org.junit.Test;

public class NumberPointTypeTest {

    private static final String INVALID_NAME = "INVALID_NAME";

	@Test
    public void match_returns_null_when_invalid_enum_name() {
        assertNull(NumberPointType.match(INVALID_NAME));
    }
    
    @Test(expected=IllegalArgumentException.class)
	public void valueOf_throws_exception_when_invalid_enum_name() throws Exception {
    	NumberPointType.valueOf(INVALID_NAME);
	}
    
    @Test
    public void match_returns_valueOf_string() throws Exception {
        assertEquals(POINT, match("POINT"));
        assertEquals(COMMA, match("COMMA"));
        assertEquals(WHITESPACE, match("WHITESPACE"));
        assertEquals(NONE, match("NONE"));
        assertEquals(DEFAULT, match("DEFAULT"));
    }
    
    @Test
    public void all_values_accounted_for_in_tests() throws Exception {
        /* Developer Note: This test is intended to break if set of values of the 
         * enum type changes. If that happens, review the other tests here to make 
         * sure that they cover the complete and current set of enum values.
         */
        assertArrayEquals(new NumberPointType[] {POINT, COMMA, WHITESPACE, NONE, DEFAULT}, 
                NumberPointType.values());
    }
}
