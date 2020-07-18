package servlet;

import javax.servlet.*;

/**
 * DO NOT CHANGE.
 */
class MyServletOutputStream extends ServletOutputStream {
    private final StringBuilder out = new StringBuilder();

    public void write(int b) {
        out.append((char) b);
    }

    public String getContent() {
        return out.toString();
    }
}
