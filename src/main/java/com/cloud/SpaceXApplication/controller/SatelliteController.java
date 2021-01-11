package com.cloud.SpaceXApplication.controller;


import org.springframework.web.bind.annotation.RestController;

import com.cloud.SpaceXApplication.model.MockResponse;
import com.cloud.SpaceXApplication.model.Satellite;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@Api(value = "satellite")
public interface SatelliteController {
	
	@ApiOperation(value = "Add to Constellation", nickname = "addSatellite", notes = "Returns the status", response = MockResponse.class, tags={ "satellite", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = MockResponse.class),
            @ApiResponse(code = 400, message = "Invalid satellite id", response = MockResponse.class),
            @ApiResponse(code = 404, message = "satellite not found", response = MockResponse.class) })
    @RequestMapping(value = "/satellite/add/{satelliteID}",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<MockResponse> addSatellite(@ApiParam(value = "Satellite ID",required=true)
                                               @PathVariable("satelliteID") Long satelliteID);
	
	@ApiOperation(value = "Decommission from Constellation", nickname = "removeSatellite", notes = "Returns the status", response = MockResponse.class, tags={ "satellite", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = MockResponse.class),
            @ApiResponse(code = 400, message = "Invalid satellite id", response = MockResponse.class),
            @ApiResponse(code = 404, message = "satellite not found", response = MockResponse.class) })
    @RequestMapping(value = "/satellite/remove/{satelliteID}",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<MockResponse> removeSatellite(@ApiParam(value = "Satellite ID",required=true)
                                               @PathVariable("satelliteID") Long satelliteID);
	
	@ApiOperation(value = "Check the health of the satellite", nickname = "checkHealth", notes = "Returns the status", response = Satellite.class, tags={ "satellite", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Satellite.class),
            @ApiResponse(code = 400, message = "Invalid satellite id", response = MockResponse.class),
            @ApiResponse(code = 404, message = "satellite not found", response = MockResponse.class) })
    @RequestMapping(value = "/satellite/health/{satelliteID}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Satellite> checkHealth(@ApiParam(value = "Satellite ID",required=true)
                                               @PathVariable("satelliteID") Long satelliteID);

	
}
