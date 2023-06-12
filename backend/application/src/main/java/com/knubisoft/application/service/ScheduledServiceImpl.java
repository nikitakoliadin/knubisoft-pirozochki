package com.knubisoft.application.service;

import com.knubisoft.application.util.FireCpuLoadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledServiceImpl implements ScheduleService {
    private final FireCpuLoadUtil fireCpuLoadUtil;

    @Autowired
    public ScheduledServiceImpl(final FireCpuLoadUtil fireCpuLoadUtil) {
        this.fireCpuLoadUtil = fireCpuLoadUtil;
    }

    @Override
    @Scheduled(fixedRateString = "${scheduled.fixeRate}")
    public void getCpuLoadScheduled() {
        fireCpuLoadUtil.fireCpuLoad();
    }
}
