package com.conexia.webflows;

/**
 * Created by pbastidas on 23/10/14.
 */
public interface Log {
    void error(String msg, Exception e);
    void warn(String msg, Exception e);
    void debug(String msg);
    void info(String msg);
}
