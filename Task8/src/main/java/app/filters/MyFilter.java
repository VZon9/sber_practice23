package app.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Component
public class MyFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(MyFilter.class.getName());


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String doFilter = "doFilter: ";
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        logger.info(doFilter + "start");
        Map<String, String[]> paramsMap = httpRequest.getParameterMap();
        if (!paramsMap.isEmpty()) {
            for (String param : paramsMap.keySet()) {
                String[] values = paramsMap.get(param);
                logger.info(doFilter + "parameter " + param + "=" + Arrays.toString(values));
            }
        }
        else {
            logger.info(doFilter + "not parameters");
        }
        logger.info(doFilter + "current url is " + httpRequest.getRequestURI());
        logger.info(doFilter + "method is " + httpRequest.getMethod());
        logger.info(doFilter + "local port is " + httpRequest.getLocalPort());
        logger.info(doFilter + "remote port is " + httpRequest.getRemotePort());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
