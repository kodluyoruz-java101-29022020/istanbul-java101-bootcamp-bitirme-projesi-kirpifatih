package dao.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ReadBook")
public class ReadBook implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@org.springframework.data.annotation.Id
	@Column(name = "id_Read")
	private Long id_Read;
	
	@Column(name = "Title")
	private String Title;
	
	@Column(name = "PressYear")
	@Temporal(TemporalType.DATE)
	private Date PressYear;
	
	@Column(name="Description")
	private String Description;
	
	@Column(name="Author")
	private String Author;
	
	
	public Long getEmpNo() {
		return id_Read;
	}

	public void setEmpNo(Long id_Read) {
		this.id_Read =id_Read;
	}
	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title =Title;
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
		this.Author =Author;
	}


}
