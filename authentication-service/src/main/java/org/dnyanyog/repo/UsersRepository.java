package org.dnyanyog.repo;

import java.util.List;
import java.util.Optional;

import org.dnyanyog.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends JpaRepository<Users , Long>{
		
}
