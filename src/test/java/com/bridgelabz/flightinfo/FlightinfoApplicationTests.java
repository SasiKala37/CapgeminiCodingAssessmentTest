package com.bridgelabz.flightinfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bridgelabz.flightinfo.controller.CheapFlightController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightinfoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	private CheapFlightController cheapFlightController;

}
