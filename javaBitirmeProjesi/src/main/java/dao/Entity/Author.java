package dao.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Author")
public class Author implements Serializable{

	
	private static final long serialVersionUID = 4957144670390541351L;

	

	@Id
	@org.springframework.data.annotation.Id
	@Column(name = "id_Author")
	private Long id_Author;
	
	@Column(name="AuthorName")
	private String AuthorName;
	
	public Long getid_Author() {
		return id_Author;
	}

	public void setid_Author(Long id_Author) {
		this.id_Author = id_Author;
	}
	

}
