package com.jetty;

import com.SpringBeanTestMainClass;
import com.interfaces.CarStoreOwner;
import com.services.SpringServices;
import io.prometheus.client.Counter;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Component
public class JettyHandler implements Handler {

    @Autowired
    private SpringServices springServices;

    public JettyHandler() {

    }

    public JettyHandler(String s) {

    }

    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        out.println("<h1>" + "target: " + target + "</h1>");

        List<CarStoreOwner> carStoreOwnerList = springServices.getCarStoreOwnerList();
        for (CarStoreOwner carOwn : carStoreOwnerList) {
            out.println("<h1>" + "Name " + carOwn.getName() + "</h1>");
        }
        out.println("<h1>" + "Name from DB" + springServices.getCarStoreOwnerFronDB() + "</h1>");

        baseRequest.setHandled(true);
    }

    public static class GrafanaNewMetricExampleServlet extends HttpServlet {
        static final Counter requests = Counter.build()
                .name("grafana_hello_worlds_total")
                .help("Number of hello worlds served.").register();

        @Override
        protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
                throws IOException {
            resp.getWriter().println("Hello World!");
            requests.inc();
        }
    }

    public void setServer(Server server) {

    }

    public Server getServer() {
        return null;
    }

    public void destroy() {

    }

    public void start() {

    }

    public void stop() {

    }

    public boolean isRunning() {
        return false;
    }

    public boolean isStarted() {
        return false;
    }

    public boolean isStarting() {
        return false;
    }

    public boolean isStopping() {
        return false;
    }

    public boolean isStopped() {
        return false;
    }

    public boolean isFailed() {
        return false;
    }

    public void addLifeCycleListener(Listener listener) {

    }

    public void removeLifeCycleListener(Listener listener) {

    }
}