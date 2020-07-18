package playground.chapter2_ThreadSafety;

import net.jcip.annotations.GuardedBy;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

import static math.Factorizer.factor;

/**
 * Better way
 */
public  class CachedFactorizer implements Servlet {
    @GuardedBy("this")
    private BigInteger lastNumber;
    @GuardedBy("this")
    private BigInteger[] lastFactors;

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = null;
        synchronized (this){
            if(i.equals(lastNumber))
                factors = lastFactors.clone();
        }

        if(factors == null){
            factors = factor(i);
            synchronized (this){
                lastNumber = i;
                lastFactors = factors.clone();
            }

        }
        encodeIntoResponse(resp,factors);

    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
        // some implementation
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        // some implementation to return a BigInteger
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
