package acc.br.sap_university.product.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@EntityScan
@Table(name = "TBG_STUDENT")
public class StudentModel{

    @Id
    private Long id;
    private String name;
    private String cep;
    private String localidade;
    private LocalDate birthDate;
    private String subject;

    public StudentModel() {
    }

    public StudentModel(Long id, String name, String cep, String localidade, LocalDate birthDate, String subject) {
        this.id = id;
        this.name = name;
        this.cep = cep;
        this.localidade = localidade;
        this.birthDate = birthDate;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentModel that = (StudentModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cep='" + cep + '\'' +
                ", localidade='" + localidade + '\'' +
                ", birthDate=" + birthDate +
                ", subject='" + subject + '\'' +
                '}';
    }
}
