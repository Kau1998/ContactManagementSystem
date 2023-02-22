package com.contactmanagementsystem.repository;

import com.contactmanagementsystem.entity.Sample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Samplerepo extends JpaRepository<Sample, Long> {
	@Query(value = "SELECT * FROM sample u WHERE CONCAT(u.first_name, ' ', u.email,' ',u.last_name) LIKE %?1%", nativeQuery = true)
    List<Sample> findAllBySearchValue(String search);
	
}
