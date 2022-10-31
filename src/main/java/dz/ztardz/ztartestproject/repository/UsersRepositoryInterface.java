package dz.ztardz.ztartestproject.repository;

import dz.ztardz.ztartestproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepositoryInterface extends JpaRepository<Users, Integer>{
    Users findByLoginUser(String loginUser);
}