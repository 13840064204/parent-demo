package com.coderabbit.security.dao;

import com.coderabbit.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    List<UserRole> findByUserIdAndStatus(String userId,Integer status);
}
