package org.dnyanyog.repo;

import org.dnyanyog.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders , Long>{

	
}
