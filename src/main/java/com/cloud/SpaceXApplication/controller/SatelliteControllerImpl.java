package com.cloud.SpaceXApplication.controller;

import org.springframework.http.ResponseEntity;

import com.cloud.SpaceXApplication.model.MockResponse;
import com.cloud.SpaceXApplication.model.Satellite;
import com.cloud.SpaceXApplication.service.SatelliteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@Api(tags = {"satellite"})
public class SatelliteControllerImpl implements SatelliteController{
	
	@Autowired
    private SatelliteService satelliteService;

    @Override
    public ResponseEntity<MockResponse> addSatellite(@ApiParam(value = "Satellite ID",required=true) @PathVariable("satelliteID") Long satelliteID) {
    	
        if(satelliteService.addSatellite(satelliteID) > 0) {
        	System.out.println("test build");
            return new ResponseEntity<>(new MockResponse(204 ,"Successfully added the constellation"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MockResponse(404, "Satellite not found"), HttpStatus.NOT_FOUND);
        }

    }
    
    public ResponseEntity<MockResponse> removeSatellite(@ApiParam(value = "Satellite ID",required=true) @PathVariable("satelliteID") Long satelliteID) {
    	
        if(satelliteService.removeSatellite(satelliteID) > 0) {
            return new ResponseEntity<>(new MockResponse(204 ,"Successfully removed from constellation"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new MockResponse(404, "Satellite not found"), HttpStatus.NOT_FOUND);
        }

    }

	@Override
	public ResponseEntity<Satellite> checkHealth(Long satelliteID) {
		
		Optional<Satellite> satellite = satelliteService.getSatelliteHealth(satelliteID);
        return satellite.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(new Satellite(), HttpStatus.NOT_FOUND));
   
	}
	

}
