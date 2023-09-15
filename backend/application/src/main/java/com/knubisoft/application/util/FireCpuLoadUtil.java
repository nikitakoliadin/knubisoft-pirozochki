package com.knubisoft.application.util;

import com.sun.management.OperatingSystemMXBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.util.concurrent.CompletableFuture;

@EnableAsync
@Slf4j
@Component
public class FireCpuLoadUtil {

    private static final int FIVE_SECONDS = 5000;

    @Async
    public void fireCpuLoad() {
        OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        log.info("Current CPU load is: " + bean.getProcessCpuLoad());
    }

    @Async
    public CompletableFuture<Double> getFireCpuLoader() {
        OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        try {
            Thread.sleep(FIVE_SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.completedFuture(bean.getProcessCpuLoad());
    }
}
