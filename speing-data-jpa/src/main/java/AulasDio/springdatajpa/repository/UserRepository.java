package AulasDio.springdatajpa.repository;

import AulasDio.springdatajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { // Interface extendida do framework JPA repository trabalhando com a classe user (permite a cesso a metodos prontos)

}
