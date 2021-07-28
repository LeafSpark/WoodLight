package com.woodlight.api;

import org.apache.commons.lang3.SystemUtils;

public class SystemWrapperUtils extends SystemUtils {
    public final String JavaVersion = SystemUtils.JAVA_VERSION;

    public final String OSName = SystemUtils.OS_NAME;

    public final String OSVersion = SystemUtils.OS_VERSION;

    public final String JavaCompiler = SystemUtils.JAVA_COMPILER;
}
