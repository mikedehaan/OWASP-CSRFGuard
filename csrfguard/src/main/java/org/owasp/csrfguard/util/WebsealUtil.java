package org.owasp.csrfguard.util;

import javax.servlet.http.HttpSession;

/**
 * User: mdehaan
 * Date: 10/2/13
 */
public class WebsealUtil {
    public static boolean isWebsealSession(HttpSession session) {
        // Check to see if we should bypass security
        Object obj = session.getAttribute("IS_WEBSEAL_USER");

        if (obj == null) {
            return false;
        }

        if (obj instanceof Boolean) {
            return (Boolean)obj;
        } else if (obj instanceof String) {
            // Attempt to cast to a boolean
            return Boolean.parseBoolean(obj.toString());
        } else {
            // Unknown type
            throw new IllegalArgumentException("IS_WEBSEAL_USER has been specified in the session, " +
                    "but is niether a String nor a boolean");
        }
    }
}
