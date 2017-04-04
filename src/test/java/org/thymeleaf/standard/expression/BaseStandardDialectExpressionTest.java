package org.thymeleaf.standard.expression;

import java.util.Properties;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

public class BaseStandardDialectExpressionTest extends AbstractExpressionTest {

    private static final String TEMPLATE = "<!DOCTYPE html><html><body><span th:text=\"{%%}\">PLACEHOLDER</span></body></html>";
    private static final String RESULT_PREFIX = "<!DOCTYPE html><html><body><span>";
    private static final String RESULT_SUFFIX = "</span></body></html>";
    
    @Override
    protected final TemplateEngine createTemplateEngine() {
        return super.createTemplateEngine();
    }
    
    @Override
    protected final String extractResult(String processedTemplate) {
        return processedTemplate.substring(RESULT_PREFIX.length(), processedTemplate.length() - RESULT_SUFFIX.length());
    }
    
    @Override
    protected final ITemplateResolver templateResolver() {
        return new TestTemplateResolver(TEMPLATE);
    }

    @Override
    protected IMessageResolver messageResolver() {
        return new TestMessageResolver(messageResolverProperties());
    }

    protected Properties messageResolverProperties() {
        return new Properties();
    }
}
