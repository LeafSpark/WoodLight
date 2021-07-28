package com.woodlight.logging;

import com.woodlight.annotation.Buggy;
import jdk.jfr.Experimental;
import org.apache.commons.math3.analysis.function.Log;

import java.util.logging.LogManager;

@Experimental
@Buggy
public class Logger {
    public Logger() {
        java.util.logging.Logger logger = java.util.logging.Logger.getAnonymousLogger();
        logger.info("Logger started!");
    }
}
