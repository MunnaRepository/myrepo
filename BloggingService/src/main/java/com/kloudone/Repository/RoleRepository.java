package com.kloudone.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.kloudone.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
	
	 Role findByRole(@Param("role") String role);
	
	

}
