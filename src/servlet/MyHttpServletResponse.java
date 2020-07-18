package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 * DO NOT CHANGE.
 */
public class MyHttpServletResponse implements HttpServletResponse {
    private final MyServletOutputStream out = new MyServletOutputStream();

    public ServletOutputStream getOutputStream() throws IOException {
        return out;
    }

    public String getContent() {
        return out.getContent();
    }

    public void addCookie(Cookie cookie) {
        throw new UnsupportedOperationException("todo");
    }

    public boolean containsHeader(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public String encodeURL(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public String encodeRedirectURL(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public String encodeUrl(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public String encodeRedirectUrl(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public void sendError(int i, String s) throws IOException {
        throw new UnsupportedOperationException("todo");
    }

    public void sendError(int i) throws IOException {
        throw new UnsupportedOperationException("todo");
    }

    public void sendRedirect(String s) throws IOException {
        throw new UnsupportedOperationException("todo");
    }

    public void setDateHeader(String s, long l) {
        throw new UnsupportedOperationException("todo");
    }

    public void addDateHeader(String s, long l) {
        throw new UnsupportedOperationException("todo");
    }

    public void setHeader(String s, String s1) {
        throw new UnsupportedOperationException("todo");
    }

    public void addHeader(String s, String s1) {
        throw new UnsupportedOperationException("todo");
    }

    public void setIntHeader(String s, int i) {
        throw new UnsupportedOperationException("todo");
    }

    public void addIntHeader(String s, int i) {
        throw new UnsupportedOperationException("todo");
    }

    public void setStatus(int i) {
        throw new UnsupportedOperationException("todo");
    }

    public void setStatus(int i, String s) {
        throw new UnsupportedOperationException("todo");
    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public String getHeader(String s) {
        return null;
    }

    @Override
    public Collection<String> getHeaders(String s) {
        return null;
    }

    @Override
    public Collection<String> getHeaderNames() {
        return null;
    }

    public String getCharacterEncoding() {
        throw new UnsupportedOperationException("todo");
    }

    public String getContentType() {
        throw new UnsupportedOperationException("todo");
    }

    public PrintWriter getWriter() throws IOException {
        throw new UnsupportedOperationException("todo");
    }

    public void setCharacterEncoding(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public void setContentLength(int i) {
        throw new UnsupportedOperationException("todo");
    }

    public void setContentType(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public void setBufferSize(int i) {
        throw new UnsupportedOperationException("todo");
    }

    public int getBufferSize() {
        throw new UnsupportedOperationException("todo");
    }

    public void flushBuffer() throws IOException {
        throw new UnsupportedOperationException("todo");
    }

    public void resetBuffer() {
        throw new UnsupportedOperationException("todo");
    }

    public boolean isCommitted() {
        throw new UnsupportedOperationException("todo");
    }

    public void reset() {
        throw new UnsupportedOperationException("todo");
    }

    public void setLocale(Locale locale) {
        throw new UnsupportedOperationException("todo");
    }

    public Locale getLocale() {
        throw new UnsupportedOperationException("todo");
    }

}
