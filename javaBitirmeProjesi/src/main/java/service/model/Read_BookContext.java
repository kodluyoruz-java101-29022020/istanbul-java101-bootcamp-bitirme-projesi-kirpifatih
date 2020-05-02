package service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import dao.Entity.Author;

public class Read_BookContext implements Serializable {

	
	private static final long serialVersionUID = 6528823506608017387L;
	
    private Long id_Read;
    private String Title;	
    private Date PressYear;
	private String Description;	
	private String Author;
	
	public Long getid_Read() {
		return id_Read;
	}

	public void setid_Read(Long id_Read) {
		this.id_Read =id_Read;
	}
	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title =Title;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description=Description;
	}
	public Date getPressYear() {
		return PressYear;
	}
	

	public void setPressYear(Date PressYear) {
		this.PressYear =PressYear;
	}
	

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String Author) {
		this.Author = Author;
	}

}
