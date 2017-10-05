package com.redhat.bpm.remotemonitoring.scheduler.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.SerializationUtils;

public class MonitorDefinition implements Serializable, Cloneable {


    public enum Status {
        FINISHED, STARTED
    }

    public enum MonitorType {
        ACTIVE_INSTANCES
    }

    @JsonIgnore
    private String uuid;
    @JsonIgnore
    private Status status = Status.STARTED;

    private String enabled;
    private MonitorType type;
    private String name;
    private String description;
    private List<String> processesBlackList;
    private List<KieServerDefinition> kieservers;
    private ScheduleDefinition schedule;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ScheduleDefinition getScheduleExprName() {
        return schedule;
    }

    public void setScheduleExprName(ScheduleDefinition schedule) {
        this.schedule = schedule;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public MonitorType getType() {
        return type;
    }

    public void setType(MonitorType type) {
        this.type = type;
    }

    public List<String> getProcessesBlackList() {
        return processesBlackList;
    }

    public void setProcessesBlackList(List<String> processesBlackList) {
        this.processesBlackList = processesBlackList;
    }

    public List<KieServerDefinition> getKieservers() {
        return kieservers;
    }

    public void setKieservers(List<KieServerDefinition> kieservers) {
        this.kieservers = kieservers;
    }

    public ScheduleDefinition getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleDefinition schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof MonitorDefinition)) return false;
        MonitorDefinition other = (MonitorDefinition) o;
        return (this.uuid.equalsIgnoreCase(other.uuid));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return SerializationUtils.clone(this);
    }
}