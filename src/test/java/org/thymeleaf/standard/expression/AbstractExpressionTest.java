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
 * in a dialect. Subclasses should override the {@link #createTemplateEngine}
 * method to return the appropriate template engine to use.
 * 
 * @see TemplateEngine
 * @see IMessageResolver
 * @see ITemplateResolver
 *  
 * @author Junilu Lacar
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

    /**
     * Evaluates the given expression using the context provided
     * by {@link #defaultContext()}.
     * 
     * @param expression    the expression to evaluate
     * @return  the result of processing the expression with this
     *          test's template engine and default context
     */
    protected final String eval(final String expression) {
        return eval(expression, defaultContext());
    }
    
    /**
     * Evaluates the given expression using the given context.
     * 
     * @param expression    the expression to evaluate
     * @param context       the context to use when processing the expression
     * @return  the result of processing the expression with this
     *          test's template engine and the given context
     */
    protected final String eval(final String expression, IContext context) {
        return extractResult(this.templateEngine.process(expression, context));
    }
    
    /***
     * Returns the template engine used by this test.
     * 
     * @return  the template engine used by this test
     */
    protected final TemplateEngine templateEngine() {
        return this.templateEngine;
    }
    
    /**
     * Returns the context to use with {@link #eval(String)}.
     * Override this method if you want to use a different 
     * context instead. 
     * 
     * @return  the context to use if one is not specified 
     *          for evaluating an expression
     */
    protected IContext defaultContext() {
        return DEFAULT_CONTEXT;
    }
    
    /**
     * Extracts the result that this test's assertions are going
     * to be checking. Defaults to the entire processed template.
     * <p>
     * Override this method to customize what the {@link #eval} method 
     * returns. You may want to do this if you're only interested in
     * checking the part or parts of the processed template that was 
     * changed by the template engine, thus ignoring any of the static 
     * boilerplate parts and making test assertions cleaner and clearer.
     * 
     * @param processedTemplate     the result of processing this test's
     *                              template with its template engine
     *                              
     * @return  the part of the processed template that this test's 
     *          assertions are going to check 
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
     * Returns the {@link ITemplateResolver} implementation to use with
     * the template engine in this test.
     * 
     * @return the template resolver to use
     */
    protected abstract ITemplateResolver templateResolver();
    
    /**
     * Returns the {@link IMessageResolver} implementation to use with
     * the template engine in this test.
     * 
     * @return the message resolver to use
     */
    protected abstract IMessageResolver messageResolver();
    
}
