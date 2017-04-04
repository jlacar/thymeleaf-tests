package org.thymeleaf.standard.expression;

import java.util.Locale;

import org.junit.Before;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * Abstract base class for testing expressions in a dialect.
 * <p>
 * This class provides the boilerplate code for testing expressions 
 * in a dialect. Subclasses should implement the getTemplateEngine()
 * method and the 
 *  
 * @author jlacar
 */
public abstract class AbstractExpressionTest {

    private static final IContext DEFAULT_CONTEXT = new Context(Locale.US); 
    
    private TemplateEngine templateEngine;

    @Before
    public final void setupTemplateEngine() {
        this.templateEngine = createTemplateEngine();
        this.templateEngine.setTemplateResolver(templateResolver());
        this.templateEngine.setMessageResolver(messageResolver());
    }

    protected final String eval(final String expression) {
        return eval(expression, defaultContext());
    }
    
    protected final String eval(final String expression, IContext context) {
        return extractResult(this.templateEngine.process(expression, context));
    }
    
    protected final TemplateEngine templateEngine() {
        return this.templateEngine;
    }
    
    protected IContext defaultContext() {
        return DEFAULT_CONTEXT;
    }
    
    /**
     * 
     * @param processedTemplate
     * @return
     */
    protected String extractResult(String processedTemplate) {
        return processedTemplate;
    }
    
    /**
     * Creates the template engine that will be used in this test.
     * <p>
     * By default, this creates a Standard Thymeleaf template engine.
     *  
     * @return the template engine to use in this test
     */
    protected TemplateEngine createTemplateEngine() {
        return new TemplateEngine();
    }
    
    /**
     * Returns the ITemplateResolver implementation to use with
     * the template engine in this test.
     * 
     * @return the template resolver to use
     */
    protected abstract ITemplateResolver templateResolver();
    
    /**
     * Returns the IMessageResolver implementation to use with
     * the template engine in this test.
     * 
     * @return the message resolver to use
     */
    protected abstract IMessageResolver messageResolver();
    
}
