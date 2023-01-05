package com.example.loki_a10.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListKPResponse{

	@SerializedName("end_at")
	private String endAt;

	@SerializedName("agency")
	private String agency;

	@SerializedName("supervisor_id")
	private int supervisorId;

	@SerializedName("seminar_room_id")
	private int seminarRoomId;

	@SerializedName("title")
	private String title;

	@SerializedName("start_at")
	private Object startAt;

	@SerializedName("seminar_date")
	private String seminarDate;

	@SerializedName("seminar_room_name")
	private String seminarRoomName;

	@SerializedName("grade")
	private String grade;

	@SerializedName("seminar_deadline")
	private Object seminarDeadline;

	@SerializedName("audiences")
	private List<Object> audiences;

	@SerializedName("id")
	private int id;

	@SerializedName("supervisor")
	private String supervisor;

	@SerializedName("status")
	private int status;

	public String getEndAt(){
		return endAt;
	}

	public String getAgency(){
		return agency;
	}

	public int getSupervisorId(){
		return supervisorId;
	}

	public int getSeminarRoomId(){
		return seminarRoomId;
	}

	public String getTitle(){
		return title;
	}

	public Object getStartAt(){
		return startAt;
	}

	public String getSeminarDate(){
		return seminarDate;
	}

	public String getSeminarRoomName(){
		return seminarRoomName;
	}

	public String getGrade(){
		return grade;
	}

	public Object getSeminarDeadline(){
		return seminarDeadline;
	}

	public List<Object> getAudiences(){
		return audiences;
	}

	public int getId(){
		return id;
	}

	public String getSupervisor(){
		return supervisor;
	}

	public int getStatus(){
		return status;
	}
}