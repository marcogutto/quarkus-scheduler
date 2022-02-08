package com.example.scheduler.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.example.scheduler.domain.ScheduleEvent;
import com.example.scheduler.domain.ScheduleEventStatus;
import com.example.scheduler.mapper.ScheduleEventMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class SchedulerService {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerService.class);

    @Inject
    private ScheduleEventMapper scheduleEventMapper;

    @Transactional
    @Scheduled(every = "9s")
    void runScheduledTask(){
        ScheduleEvent.findByDatetimeAndStatusAndEnabled().forEach(scheduleEvent -> {

            scheduleEvent.setStatus(ScheduleEventStatus.PROCESSED);
            scheduleEvent.persistAndFlush();

            logger.info(scheduleEvent.getDateTime().toString());
        } );
    }


}
