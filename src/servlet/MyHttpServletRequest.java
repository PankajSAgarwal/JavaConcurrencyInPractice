package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.security.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * DO NOT CHANGE.
 */
public class MyHttpServletRequest implements HttpServletRequest {
    private final Map<String, String> parameters = new ConcurrentHashMap<String, String>();

    public MyHttpServletRequest(String... parameterPairs) {
        for (int i = 0; i < parameterPairs.length; i += 2) {
            parameters.put(parameterPairs[i], parameterPairs[i + 1]);
        }
    }

    public String getParameter(String name) {
        return parameters.get(name);
    }

    public String getAuthType() {
        throw new UnsupportedOperationException("todo");
    }

    public Cookie[] getCookies() {
        throw new UnsupportedOperationException("todo");
    }

    public long getDateHeader(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public String getHeader(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public Enumeration<String> getHeaders(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public Enumeration<String> getHeaderNames() {
        throw new UnsupportedOperationException("todo");
    }

    public int getIntHeader(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public String getMethod() {
        throw new UnsupportedOperationException("todo");
    }

    public String getPathInfo() {
        throw new UnsupportedOperationException("todo");
    }

    public String getPathTranslated() {
        throw new UnsupportedOperationException("todo");
    }

    public String getContextPath() {
        throw new UnsupportedOperationException("todo");
    }

    public String getQueryString() {
        throw new UnsupportedOperationException("todo");
    }

    public String getRemoteUser() {
        throw new UnsupportedOperationException("todo");
    }

    public boolean isUserInRole(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public Principal getUserPrincipal() {
        throw new UnsupportedOperationException("todo");
    }

    public String getRequestedSessionId() {
        throw new UnsupportedOperationException("todo");
    }

    public String getRequestURI() {
        throw new UnsupportedOperationException("todo");
    }

    public StringBuffer getRequestURL() {
        throw new UnsupportedOperationException("todo");
    }

    public String getServletPath() {
        throw new UnsupportedOperationException("todo");
    }

    public HttpSession getSession(boolean b) {
        throw new UnsupportedOperationException("todo");
    }

    public HttpSession getSession() {
        throw new UnsupportedOperationException("todo");
    }

    public boolean isRequestedSessionIdValid() {
        throw new UnsupportedOperationException("todo");
    }

    public boolean isRequestedSessionIdFromCookie() {
        throw new UnsupportedOperationException("todo");
    }

    public boolean isRequestedSessionIdFromURL() {
        throw new UnsupportedOperationException("todo");
    }

    public boolean isRequestedSessionIdFromUrl() {
        throw new UnsupportedOperationException("todo");
    }

    @Override
    public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
        return false;
    }

    @Override
    public void login(String s, String s1) throws ServletException {

    }

    @Override
    public void logout() throws ServletException {

    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        return null;
    }

    @Override
    public Part getPart(String s) throws IOException, ServletException {
        return null;
    }

    public Object getAttribute(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public Enumeration<String> getAttributeNames() {
        throw new UnsupportedOperationException("todo");
    }

    public String getCharacterEncoding() {
        throw new UnsupportedOperationException("todo");
    }

    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {
        throw new UnsupportedOperationException("todo");
    }

    public int getContentLength() {
        throw new UnsupportedOperationException("todo");
    }

    public String getContentType() {
        throw new UnsupportedOperationException("todo");
    }

    public ServletInputStream getInputStream() throws IOException {
        throw new UnsupportedOperationException("todo");
    }


    public Enumeration<String> getParameterNames() {
        throw new UnsupportedOperationException("todo");
    }

    public String[] getParameterValues(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public Map<String, String[]> getParameterMap() {
        throw new UnsupportedOperationException("todo");
    }

    public String getProtocol() {
        throw new UnsupportedOperationException("todo");
    }

    public String getScheme() {
        throw new UnsupportedOperationException("todo");
    }

    public String getServerName() {
        throw new UnsupportedOperationException("todo");
    }

    public int getServerPort() {
        throw new UnsupportedOperationException("todo");
    }

    public BufferedReader getReader() throws IOException {
        throw new UnsupportedOperationException("todo");
    }

    public String getRemoteAddr() {
        throw new UnsupportedOperationException("todo");
    }

    public String getRemoteHost() {
        throw new UnsupportedOperationException("todo");
    }

    public void setAttribute(String s, Object o) {
        throw new UnsupportedOperationException("todo");
    }

    public void removeAttribute(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public Locale getLocale() {
        throw new UnsupportedOperationException("todo");
    }

    public Enumeration<Locale> getLocales() {
        throw new UnsupportedOperationException("todo");
    }

    public boolean isSecure() {
        throw new UnsupportedOperationException("todo");
    }

    public RequestDispatcher getRequestDispatcher(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public String getRealPath(String s) {
        throw new UnsupportedOperationException("todo");
    }

    public int getRemotePort() {
        throw new UnsupportedOperationException("todo");
    }

    public String getLocalName() {
        throw new UnsupportedOperationException("todo");
    }

    public String getLocalAddr() {
        throw new UnsupportedOperationException("todo");
    }

    public int getLocalPort() {
        throw new UnsupportedOperationException("todo");
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        return null;
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        return null;
    }

    @Override
    public boolean isAsyncStarted() {
        return false;
    }

    @Override
    public boolean isAsyncSupported() {
        return false;
    }

    @Override
    public AsyncContext getAsyncContext() {
        return null;
    }

    @Override
    public DispatcherType getDispatcherType() {
        return null;
    }
}
