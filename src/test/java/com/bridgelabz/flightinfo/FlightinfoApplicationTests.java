package com.bridgelabz.flightinfo;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bridgelabz.flightinfo.controller.CheapFlightController;

/**
 * To test the CheapFlightController class
 * 
 * @author sasikala
 * @since 05-10-2018
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightinfoApplicationTests {

	@Test
	public void contextLoads() {
	}

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	/**
	 * 
	 * Junit Test cases (run with help of internet)
	 */
	@Test
	public void getTokenTest() throws Exception {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		mockMvc.perform(post("/gettoken")).andExpect(status().isOk());
	}

	@Test
	public void getFlightInfoTest() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		mockMvc.perform(get("/getcheapfilghtinfo")).andExpect(status().isOk());
	}

	/**
	 * Mock test cases(run without internet)
	 *
	 */
	@InjectMocks
	private CheapFlightController cheapFlightController;

	@Test
	public void mockGetToken() throws Exception {
		cheapFlightController = mock(CheapFlightController.class);
		this.mockMvc = MockMvcBuilders.standaloneSetup(cheapFlightController).build();
		mockMvc.perform(post("/gettoken")).andExpect(status().isOk());

	}

	@Test
	public void getFlightInfo() throws Exception {
		cheapFlightController = mock(CheapFlightController.class);
		this.mockMvc = MockMvcBuilders.standaloneSetup(cheapFlightController).build();
		mockMvc.perform(get("/getcheapfilghtinfo")).andExpect(status().isOk());
	}
}
