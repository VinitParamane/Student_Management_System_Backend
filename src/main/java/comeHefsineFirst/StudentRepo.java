package comeHefsineFirst;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	
	List<Student> findByMarksGreaterThan(int marks);
	List<Student> findByMarksGreaterThanAndMarksLessThan(int min,int max);
	int countByMarksGreaterThanAndMarksLessThan(int min,int max);
	List<Student> findTop2ByOrderByMarksDesc();
	List<Student> findByNameIsNotNull();
	List<Student> findDistinctByName(String navv);
	List<Student> findByOrderByNameAsc();
	List<Student> findByNameContaining(String part);
	List<Student> findByNameAndMarks(String Name, int marks);
	List<Student> findByName(String Name);
}
