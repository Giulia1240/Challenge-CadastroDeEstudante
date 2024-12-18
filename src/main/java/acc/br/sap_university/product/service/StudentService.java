package acc.br.sap_university.product.service;
import acc.br.sap_university.product.model.StudentModel;
import acc.br.sap_university.product.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CepService cepService;

    public ResponseEntity<acc.br.sap_university.product.model.StudentModel> save(acc.br.sap_university.product.model.StudentModel studentModel) {
        if (studentModel.getCep() != null && !studentModel.getCep().isEmpty()) {
            acc.br.sap_university.product.model.StudentModel addressData = cepService.findAdressByCep(studentModel.getCep());
            if (addressData != null) {
                studentModel.setLocalidade(addressData.getLocalidade());
            }
        }
        return new ResponseEntity<>(studentRepository.save(studentModel), HttpStatus.OK);
    }

    public ResponseEntity<acc.br.sap_university.product.model.StudentModel> update(Long id, StudentModel studentModel) {
        Optional<acc.br.sap_university.product.model.StudentModel> update = studentRepository.findById(id);
        if (update.isPresent()) {
            acc.br.sap_university.product.model.StudentModel _student = update.get();
            _student.setName(_student.getName());
            _student.setBirthDate(_student.getBirthDate());
            _student.setCep(_student.getCep());
            _student.setSubject(_student.getSubject());

            if (_student.getCep() != null && !_student.getCep().isEmpty()) {
                acc.br.sap_university.product.model.StudentModel addressData = cepService.findAdressByCep(_student.getCep());
                if (addressData != null) {
                    _student.setLocalidade(addressData.getLocalidade());
                }
            }

            return new ResponseEntity<>(studentRepository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public List<StudentModel> findAll() {
        return studentRepository.findAll();
    }
    public StudentModel getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
    public interface CepService {
        @GetMapping("{cep}/json")
        StudentModel findAdressByCep(@PathVariable("cep") String cep);
    }
}
