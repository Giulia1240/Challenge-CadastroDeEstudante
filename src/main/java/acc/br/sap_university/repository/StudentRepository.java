package acc.br.sap_university.repository;

import acc.br.sap_university.model.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel,Long> {

    Optional<StudentModel> findById(Long id);
    List<StudentModel> findAll();

}
