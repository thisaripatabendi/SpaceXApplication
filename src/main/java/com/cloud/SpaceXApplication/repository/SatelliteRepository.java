package com.cloud.SpaceXApplication.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import com.cloud.SpaceXApplication.model.Satellite;

@Repository
public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
	
	@Modifying
    @Transactional
    @Query("update Satellite sl set sl.status = :status where sl.id = :satelliteID")
    int addSatellite(Long satelliteID, String status);
	
	@Modifying
    @Transactional
    @Query("update Satellite sl set sl.status = :status where sl.id = :satelliteID")
    int removeSatellite(Long satelliteID, String status);
	
	Optional<Satellite> findById(Long satelliteID);
}
