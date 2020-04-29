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
@Table(name="Author")
public class Author implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@org.springframework.data.annotation.Id
	@Column(name = "id_Author")
	private Long id_Author;
	
	@Column(name="AuthorName")
	private String AuthorName;
	
	

}
