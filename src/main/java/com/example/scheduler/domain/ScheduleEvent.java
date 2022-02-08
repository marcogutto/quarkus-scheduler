package com.example.scheduler.domain;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)

@Entity
@Table(name="schedule_event")
public class ScheduleEvent extends PanacheEntityBase{

    @Id
	@TableGenerator(name="schedule_seq", table="sequence", initialValue = 0, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="schedule_seq")
    private Long id;

    @NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date dateTime;

	private ScheduleEventStatus status;
	
	private boolean enabled;
 
    public ScheduleEvent() {
        super();
	}

	public void setStatus(ScheduleEventStatus status){
		this.status = status;
	}

	public static List<ScheduleEvent> findByDatetimeAndStatusAndEnabled() {
		return find("dateTime < ?1 and status = ?2 and enabled = ?3", Date.from(Instant.now()), ScheduleEventStatus.SCHEDULED, true).list();
	}
    
}
