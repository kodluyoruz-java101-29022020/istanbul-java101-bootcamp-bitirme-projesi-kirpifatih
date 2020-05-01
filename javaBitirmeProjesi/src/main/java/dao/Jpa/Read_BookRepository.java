package dao.Jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dao.Entity.Read_Book;
import service.model.Read_BookProfile;

@Repository
public interface  Read_BookRepository extends CrudRepository<Read_Book, Long>{


	@Query(value = "FROM Read_Book e WHERE e.id_Read = :id_Read")
	public Read_Book findWithid_Read(@Param("empNo") Long id_Read);
	
	@Query(value = "SELECT MAX(e.id_Read) FROM Read_Book e")
	public Long findMaxId();
	
	@Query(value = "SELECT e FROM Read_Book e")
	public List<Read_Book> getAllRead_BookList();
	
	
	@Query(value = "SELECT new service.model.Read_BookProfile(read, readB.name) FROM Read_Book read LEFT OUTER JOIN read.Author readB")
	public List<Read_BookProfile> getAllRead_BookProfileList(Pageable pageable);
}
