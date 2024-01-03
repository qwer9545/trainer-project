package com.fisa.gym.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fisa.gym.model.domain.Membership;


@Repository
public interface MembershipRepository extends JpaRepository<Membership, Long>{

	@Query(value="select TIMESTAMPDIFF(day, recent_visit, now()) from membership where membership_id = :id", nativeQuery = true)
	Long findDateDayById(@Param("id") long id);
	    
}