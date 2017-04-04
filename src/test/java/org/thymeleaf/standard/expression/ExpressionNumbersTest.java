package org.thymeleaf.standard.expression;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

public class ExpressionNumbersTest extends BaseStandardDialectExpressionTest {

    @Test
    public void formatInteger_zero_pads_when_minIntegerDigits_has_more_places() {
        assertThat(eval("${#numbers.formatInteger(5, 3)}"), is("005"));
    }
    
    @Test
    public void formatInteger_no_zero_pad_when_minIntegerDigits_has_same_places() {
        assertThat(eval("${#numbers.formatInteger(0, 1)}"), is("0"));
        assertThat(eval("${#numbers.formatInteger(9, 1)}"), is("9"));
        assertThat(eval("${#numbers.formatInteger(1234, 4)}"), is("1234"));
    }

    @Test
    public void formatInteger_no_zero_pad_when_minIntegerDigits_has_fewer_places() {
        assertThat(eval("${#numbers.formatInteger(0, 0)}"), is("0"));
        assertThat(eval("${#numbers.formatInteger(1, 0)}"), is("1"));
        assertThat(eval("${#numbers.formatInteger(9, 0)}"), is("9"));
        assertThat(eval("${#numbers.formatInteger(1234, 2)}"), is("1234"));
    }
    
    @Test
    public void formatInteger_uses_1000s_separator_NONE_by_default() {
        assertThat(eval("${#numbers.formatInteger(1234567, 0)}"), is("1234567"));
    }

    @Test
    public void formatInteger_uses_1000s_separator_when_NumberPointType_specified() {
        assertThat(eval("${#numbers.formatInteger(1234567, 0, 'NONE')}"), is("1234567"));
        assertThat(eval("${#numbers.formatInteger(1234567, 0, 'POINT')}"), is("1.234.567"));
        assertThat(eval("${#numbers.formatInteger(1234567, 0, 'COMMA')}"), is("1,234,567"));
        assertThat(eval("${#numbers.formatInteger(1234567, 0, 'WHITESPACE')}"), is("1 234 567"));
        // tests for NumberPointType.DEFAULT are separate
    }
    
    @Test
    public void formatInteger_uses_1000s_separator_of_default_locale_when_NumberPointType_is_DEFAULT() {
        // by default, context uses Locale.US
        assertThat(eval("${#numbers.formatInteger(1234567, 2, 'DEFAULT')}"), is("1,234,567"));
    }
    
    @Test
    public void formatInteger_uses_1000s_separator_per_context_locale_when_NumberPointType_is_DEFAULT() { 
        IContext de = new Context(Locale.GERMANY);
        IContext it = new Context(Locale.ITALY);
        IContext us = new Context(Locale.US);
        IContext uk = new Context(Locale.UK);

        assertThat(eval("${#numbers.formatInteger(1234567, 2, 'DEFAULT')}", de), is("1.234.567"));        
        assertThat(eval("${#numbers.formatInteger(1234567, 2, 'DEFAULT')}", it), is("1.234.567"));        
        assertThat(eval("${#numbers.formatInteger(1234567, 2, 'DEFAULT')}", us), is("1,234,567"));
        assertThat(eval("${#numbers.formatInteger(1234567, 2, 'DEFAULT')}", uk), is("1,234,567"));        
    }
        
}
