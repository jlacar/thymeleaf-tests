package org.thymeleaf.standard.expression;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionBasicObjectsTest extends BaseStandardDialectExpressionTest {
    
    @Test
    public void default_locale_is_en_US() throws Exception {
        assertThat(eval("${#locale.country}"), is("US"));
        assertThat(eval("${#locale.language}"), is("en"));
        assertThat(eval("${#locale.displayCountry}"), is("United States"));
        assertThat(eval("${#locale.displayLanguage}"), is("English"));
    }

}
