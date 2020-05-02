package dao.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Read_Book")
public class Read_Book implements Serializable {

	
	private static final long serialVersionUID = 5669171236484580444L;

	
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
	
	@OneToMany(mappedBy = "Read_Book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_Read == null) ? 0 : id_Read.hashCode());
		result = prime * result + ((Title == null) ? 0 : Title.hashCode());
		result = prime * result + ((Description == null) ? 0 : Description.hashCode());
		result = prime * result + ((PressYear == null) ? 0 : PressYear.hashCode());
		result = prime * result + ((Author == null) ? 0 : Author.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Read_Book other =(Read_Book) obj;
		if (id_Read == null) {
			if (other.id_Read != null)
				return false;
		} else if (!id_Read.equals(other.id_Read))
			return false;
		if (Title == null) {
			if (other.Title != null)
				return false;
		} else if (!Title.equals(other.Title))
			return false;
		if (Description == null) {
			if (other.Description != null)
				return false;
		} else if (!Description.equals(other.Description))
			return false;
		if (PressYear == null) {
			if (other.PressYear != null)
				return false;
		} else if (!PressYear.equals(other.PressYear))
			return false;
		if (Author == null) {
			if (other.Author != null)
				return false;
		} else if (!Author.equals(other.Author))
			return false;
		return true;
	}
	

}
