package org.thymeleaf.standard.expression;

import java.util.Properties;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * Provides the boilerplate parts of the template that will be used to
 * test expressions in the Thymeleaf Standard Dialect.
 * <p>
 * This implementation overrides the {@link #extractResult} method to
 * return only the part of the result of processed template that represents
 * the value of an expression after it has been processed by the template
 * engine.
 * <p>
 * Subclasses can override the {@link #messageResolver()} and {@link #messageResolverProperties()}
 * methods to specify custom messages.  
 * 
 * @author Junilu Lacar
 */
public class BaseStandardDialectExpressionTest extends AbstractExpressionTest {

    
    private static final String RESULT_PREFIX = "<!DOCTYPE html><html><body><span>";
    private static final String RESULT_SUFFIX = "</span></body></html>";
    
    private static final String TEMPLATE = "<!DOCTYPE html>" +
            "<html><body><span th:text=\"{%%}\">PLACEHOLDER" + RESULT_SUFFIX;;
    
    /**
     * Creates the template engine that will bu used in this test.
     * <p>
     * This implementation creates an instance of {@link TemplateEngine}.
     * 
     * @return the template engine that will be used in this test
     */
    @Override
    protected final TemplateEngine createTemplateEngine() {
        return super.createTemplateEngine();
    }
    
    /**
     * Takes the given result of processing a template and extracts the 
     * value that this test's assertions are going to be checking.
     * <p>
     * This implementation extracts only the part that corresponds to
     * the result of evaluating an expression in the Standard Dialect.
     * 
     * @return the value that will be checked by this test's assertions
     */
    @Override
    protected final String extractResult(String processedTemplate) {
        return processedTemplate.substring(RESULT_PREFIX.length(), 
                processedTemplate.length() - RESULT_SUFFIX.length());
    }
    
    /**
     * Returns the template resolver that will be used by this test's
     * template engine.
     * <p>
     * This implementation returns an instance of {@link TestTemplateResolver}  
     * that has been configured with a minimal template that includes a placeholder 
     * for one Standard Dialect expression.
     */
    @Override
    protected final ITemplateResolver templateResolver() {
        return new TestTemplateResolver(TEMPLATE);
    }

    /**
     * Returns the message resolver that will be used by this test's
     * template engine.
     * <p>
     * This implementation returns an instance of {@link TestMessageResolver}
     * that has been configured with the properties that are provided by
     * {@link #messageResolverProperties()}.
     * 
     * @return the message resolver to use with this test's template engine
     */
    @Override
    protected IMessageResolver messageResolver() {
        return new TestMessageResolver(messageResolverProperties());
    }

    /**
     * Specifies the {@link java.util.Properties} that the {@link IMessageResolver}
     * implementation used by this test will use. Override this method to customize
     * the message properties used in this test.
     * 
     * @return the message properties used in this test
     */
    protected Properties messageResolverProperties() {
        return new Properties();
    }
}
