package com.saudrav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saudrav.entity.UserRecords;

import java.util.Optional;

public interface UserRecordsRepository extends JpaRepository<UserRecords,Integer> {
	
	Optional<UserRecords> findByUsername(String username);
    

}
