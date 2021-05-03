package net.jakartaee.tutorial.jee101.app;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ResponseHeaderFilter
 */
public class ResponseHeaderFilter implements Filter {
	
	private FilterConfig initParams;

	@Override 
	public void init(FilterConfig fConfig) throws ServletException {
		initParams = fConfig;
	}		
	
	@Override 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse newResponse = (HttpServletResponse) response;
		
		Enumeration e = initParams.getInitParameterNames();
		while ( e.hasMoreElements() ) {
			String name = (String) e.nextElement();
			String value = initParams.getInitParameter(name);
			if ( "Strict-Transport-Security".equalsIgnoreCase(name)) {
									// An HSTS Host MUST NOT include the STS header field in HTTP responses conveyed over non-secure transport.
									// https://tools.ietf.org/html/rfc6797
				if (request.isSecure()) newResponse.addHeader(name, value);					
			}
			else {
				newResponse.addHeader(name, value);				
			}
		}
		
		chain.doFilter(request, response);
	}


	@Override 
	public void destroy() {}

}
