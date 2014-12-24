package org.iwb.site.bootstrap;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * Bootstrap the MVC side of the force.
 *
 * @author Mathieu POUSSE <mathieu.pousse@zenika.com>
 */
public class SiteBootstrap implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext container) {
        WebApplicationContext context = getContext();
        container.addListener(new ContextLoaderListener(context));
        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/api/*");
    }

    private AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ApplicationConfiguration.class);
        return context;
    }
}
