package playground.chapter2_ThreadSafety;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Invariant factor(lastNumber) == lastFactors
 */
@ThreadSafe
public abstract class SynchronizedFactorizer implements Servlet {

    @GuardedBy("this")
    private final AtomicReference<BigInteger> lastNumber =
            new AtomicReference<BigInteger>();
    @GuardedBy("this")
    private final AtomicReference<BigInteger[]> lastFactors =
            new AtomicReference<BigInteger[]>();
    @Override
    public synchronized void service(ServletRequest req, ServletResponse resp)
            throws ServletException, IOException {
        BigInteger i = extractFromRequest(req);
        if(i.equals(lastNumber.get()))
            encodeIntoResponse(resp,lastFactors.get());
        else{
            BigInteger[] factors = factors(i);

            lastNumber.set(i);// invariant could break here
            lastFactors.set(factors);//invariant could break here , need to update related state variables in a single atomic operation
            encodeIntoResponse(resp,factors);
        }


    }

    private BigInteger[] factors(BigInteger i) {
        // some implementation to return factors
        return new BigInteger[0];
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] bigIntegers) {
        // some implementation
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        // some implementation to return
        return null;
    }
}
