package com.example.scheduler.dto;

import java.util.Date;

import com.example.scheduler.domain.ScheduleEventStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)

public class ScheduleEventDTO{

    private Long id;

	private Date dateTime;

	private ScheduleEventStatus status;
	
	private boolean enabled;

}
