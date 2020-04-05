package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByUsername(String username);

    boolean existsUserByUsername(String username);
    boolean existsUserByEmail(String email);

    List<User> findAllByRole(String role);

    @Query(value = "SELECT * FROM user WHERE id = ? AND active = ? AND role = 'ROLE_ADMIN';", nativeQuery = true)
    User getAdminByIdAndStatus(Long id, Boolean active);

    @Query(value = "SELECT * FROM user WHERE id = ? AND role = 'ROLE_ADMIN';", nativeQuery = true)
    User getAdminById(Long id);

    @Modifying
    @Query(value = "DELETE FROM user WHERE id = ? AND role = 'ROLE_ADMIN';", nativeQuery = true)
    void deleteAdminById(Long id);

    @Query(value = "SELECT * FROM user WHERE id = ? AND active = ? AND role = 'ROLE_USER';", nativeQuery = true)
    User getUserByIdAndStatus(Long id, Boolean active);

    @Query(value = "SELECT * FROM user WHERE id = ? AND role = 'ROLE_USER';", nativeQuery = true)
    User getUserById(Long id);

    @Modifying
    @Query(value = "DELETE FROM user WHERE id = ? AND role = 'ROLE_USER';", nativeQuery = true)
    void deleteUserById(Long id);
}
