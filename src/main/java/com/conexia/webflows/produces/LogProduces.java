package com.conexia.webflows.produces;

import com.conexia.webflows.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Created by pbastidas on 23/10/14.
 */
public class LogProduces {

    @Produces
    public Log getLogger(InjectionPoint injectionPoint){

        final Logger logger = LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());

        return new Log() {
            @Override
            public void error(String msg, Exception e) {
                logger.error(msg,e);
            }

            @Override
            public void warn(String msg, Exception e) {
                logger.warn(msg, e);
            }

            @Override
            public void debug(String msg) {
                logger.debug(msg);
            }

            @Override
            public void info(String msg) {
                logger.info(msg);
            }
        };
    }

}
