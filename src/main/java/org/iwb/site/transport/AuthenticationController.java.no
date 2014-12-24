package org.iwb.site.transport;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO document me
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
@RequestMapping("/auth")
public class AuthenticationController {

    @RequestMapping("/google")
    public void authenticateWithGoogle() {

    }

}
