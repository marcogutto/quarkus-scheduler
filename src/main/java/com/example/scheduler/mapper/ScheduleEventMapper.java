package com.example.scheduler.mapper;

import java.util.List;

import com.example.scheduler.domain.ScheduleEvent;
import com.example.scheduler.dto.ScheduleEventDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ScheduleEventMapper {

	ScheduleEventDTO toScheduleEventDTO(ScheduleEvent scheduleEvent);
	List<ScheduleEventDTO> toScheduleEventDTO(List<ScheduleEvent> scheduleEvents);
	ScheduleEvent toScheduleEvent(ScheduleEventDTO scheduleEventDTO);
}
