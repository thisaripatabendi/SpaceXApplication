package com.cloud.SpaceXApplication.service;

import org.springframework.stereotype.Service;
import com.cloud.SpaceXApplication.model.Satellite;
import java.util.Optional;

@Service
public interface SatelliteService {
	
	int addSatellite(Long satelliteID);
	
	int removeSatellite(Long satelliteID);
	
	Optional<Satellite> getSatelliteHealth(Long satelliteID);

}
