package com;

import com.jetty.JettyHandler;
import com.services.CarServiceConfiguration;
import io.prometheus.client.exporter.MetricsServlet;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JettyMainClass {
    private static final Logger LOG = Logger.getLogger(JettyMainClass.class);

    public static void main(String[] args) {
        System.out.println("start");
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8070);
        server.setConnectors(new Connector[]{connector});
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CarServiceConfiguration.class);
        server.setHandler((Handler)getJettyHandlerBean());

        //   prometheusMetricsStart(server);

        try {
            server.start();
            server.join();
            server.destroy();
        } catch (Exception e) {
            LOG.error("Couldn't start http server", e);
        }
    }


    private static void prometheusMetricsStart(Server server) {
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new MetricsServlet()), "/metrics");
        context.addServlet(new ServletHolder(new JettyHandler.GrafanaNewMetricExampleServlet()), "/");/////change to bean
    }

    private static Object getJettyHandlerBean(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CarServiceConfiguration.class);
        return context.getBean(JettyHandler.class);
    }

}
