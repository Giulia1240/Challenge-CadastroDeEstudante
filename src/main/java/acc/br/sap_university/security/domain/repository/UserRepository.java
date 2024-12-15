package acc.br.sap_university.security.domain.repository;

import acc.br.sap_university.security.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

    User findBylogin(String login);
}
