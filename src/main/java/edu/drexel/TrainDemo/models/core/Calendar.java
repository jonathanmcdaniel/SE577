package edu.drexel.TrainDemo.models.core;

import java.sql.Date;

import javax.persistence.*;

@Entity
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean monday;
    private Boolean tuesday;
    private Boolean wednesday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;
    private Boolean sunday;
    private Date startDate;
	private Date endDate;

    protected Calendar(){
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getMonday() {
		return monday;
	}

	public Boolean getTuesday() {
		return tuesday;
	}

	public Boolean getWednesday() {
		return wednesday;
	}

	public Boolean getThursday() {
		return thursday;
	}

	public Boolean getFriday() {
		return friday;
	}

	public Boolean getSaturday() {
		return saturday;
	}

	public Boolean getSunday() {
		return sunday;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

    @Override
    public String toString() {
        return "Calendar{" +
                "id=" + id +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                ", sunday=" + sunday +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
	}

}