package com.conexia.webflows;

import java.io.Serializable;

/**
 * Created by pbastidas on 23/10/14.
 */
public interface Log extends Serializable{
    void error(String msg, Exception e);
    void warn(String msg, Exception e);
    void debug(String msg);
    void info(String msg);
}
