package aula_dio.diospringsecurity.repository;

import aula_dio.diospringsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// Repositorio para requisições de segurança
public interface UserRepository extends JpaRepository<User, Integer> { // usar as implemenrações do Spring com o repositorio do JPA
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username= (:username)")
    public User findByUsername(@Param("username") String username);
}
