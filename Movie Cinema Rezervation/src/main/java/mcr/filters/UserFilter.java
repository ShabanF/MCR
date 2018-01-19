package mcr.filters;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "UserFilter", urlPatterns = { "/userPages/*" })
public class UserFilter implements Filter {

	private static final String ADMIN = "admin";
	private static final String ADMIN_PAGES_ADMIN_INDEX_XHTML = "/adminPages/adminIndex.xhtml";
	private static final String USER_PAGES_INDEX_XHTML = "/userPages/index.xhtml";
	private static final String USER_PAGES_ACCOUNT_XHTML = "/userPages/account.xhtml";

	private HttpServletRequest requestServlet;
	private HttpServletResponse resp;
	private HttpSession session;
	
	public UserFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {

			this.requestServlet = (HttpServletRequest) request;
			this.resp = (HttpServletResponse) response;
			this.session = requestServlet.getSession(false);

			String reqURI = extractUrlFrom(requestServlet);

			if (isClientNotAuthenticatedUsing(reqURI)) {
				resp.sendRedirect(requestServlet.getContextPath() + USER_PAGES_INDEX_XHTML);
			}

			else if ((session != null) && (session.getAttribute(ADMIN) != null)) {
				resp.sendRedirect(requestServlet.getContextPath() + ADMIN_PAGES_ADMIN_INDEX_XHTML);
			}

			else if (reqURI.indexOf(USER_PAGES_INDEX_XHTML) >= 0) {
				chain.doFilter(request, response);
			}

			else if ((session != null) && (session.getAttribute("client") != null)) {

				if (!extractUrlFrom(requestServlet).startsWith(requestServlet.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) { // Skip
																														// JSF
					// resources
					// (CSS/JS/Images/etc)
					resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
					resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
					resp.setDateHeader("Expires", 0); // Proxies.
				}

				chain.doFilter(request, response);

			}

			else {
				resp.sendRedirect(requestServlet.getContextPath() + USER_PAGES_INDEX_XHTML);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private boolean isClientNotAuthenticatedUsing(String reqURI) {
		return reqURI.indexOf(USER_PAGES_ACCOUNT_XHTML) >= 0 && session.getAttribute("client") == null;
	}

	private String extractUrlFrom(HttpServletRequest reqt) {
		HttpServletRequest req = (HttpServletRequest) reqt;
		return req.getRequestURI();
	}

	@Override
	public void destroy() {

	}
}