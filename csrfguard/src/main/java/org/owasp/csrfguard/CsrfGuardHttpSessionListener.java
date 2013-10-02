package org.owasp.csrfguard;

import org.owasp.csrfguard.util.WebsealUtil;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CsrfGuardHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();

        // Only process tokens if this is not a webseal user
        if (!WebsealUtil.isWebsealSession(session)) {
            CsrfGuard csrfGuard = CsrfGuard.getInstance();
            csrfGuard.updateToken(session);
        }
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		/** nothing to do **/
	}

}
