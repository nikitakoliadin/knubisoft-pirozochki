package com.knubisoft.application.util;

import com.knubisoft.application.model.Task;
import com.sun.management.OperatingSystemMXBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;

@EnableAsync
@Slf4j
@Component
public class FireCpuLoadUtil {
    @Async
    public void fireCpuLoad() {
        OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        log.info("Current CPU load is: " + bean.getProcessCpuLoad());
    }
}
