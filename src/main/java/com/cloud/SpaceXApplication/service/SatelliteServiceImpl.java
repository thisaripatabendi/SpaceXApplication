package com.cloud.SpaceXApplication.service;

import com.cloud.SpaceXApplication.model.Satellite;
import com.cloud.SpaceXApplication.model.SatelliteStatus;
import com.cloud.SpaceXApplication.repository.SatelliteRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService{

    @Autowired
    private SatelliteRepository satelliteRepository;

    @Override
    public int addSatellite(Long satelliteID) {
        return satelliteRepository.addSatellite(satelliteID, SatelliteStatus.ATTACHED.getValue());
    }
    
    @Override
    public int removeSatellite(Long satelliteID) {
        return satelliteRepository.removeSatellite(satelliteID, SatelliteStatus.DETACHED.getValue());
    }

	@Override
	public Optional<Satellite> getSatelliteHealth(Long satelliteID) {
		return satelliteRepository.findById(satelliteID);
	}

}
