package dao.Jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dao.Entity.Read_Book;

@Repository
public interface  Read_BookRepository extends CrudRepository<Read_Book, Long>{


	@Query(value = "FROM Read_Book e WHERE e.id_Read = :id_Read")
	public Read_Book findWithid_Read(@Param("empNo") Long id_Read);
	
	@Query(value = "SELECT MAX(e.id_Read) FROM Read_Book e")
	public Long findMaxId();
	
	@Query(value = "SELECT e FROM Read_Book e")
	public List<Read_Book> getAllEmployeeList();
	
	//işle me yap
	/*@Query(value = "SELECT new demo.spring.boot.service.model.EmployeeProfile(emp, empDept.name) FROM Employee emp LEFT OUTER JOIN emp.departments empDept")
	public List<EmployeeProfile> getAllEmployeeProfileList(Pageable pageable);*/
}
