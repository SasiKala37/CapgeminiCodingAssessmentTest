package com.bridgelabz.flightinfo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CheapFlightController {

	@PostMapping("/gettoken")
	public ResponseEntity<String> getToken()
			throws IOException {

		String credentials = "grant_type=client_credentials";

		URL url = new URL("https://api-crt.cert.havail.sabre.com/v2/auth/token");

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");

		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Authorization",
				"Basic VmpFNk5uVndibUl4Wkc4NVkzZ3hjRFJrTVRwUVZVSk1TVU02UlZoVTpTVEJMTTBwMWRtdz0=");

		connection.setDoOutput(true);
		OutputStream os = connection.getOutputStream();
		os.write(credentials.getBytes());
		os.flush();
		os.close();

		int responseCode = connection.getResponseCode();
		//System.out.println("POST Response Code :: " + responseCode);
		StringBuffer response = new StringBuffer();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} 

		return new ResponseEntity<>(response.toString(), HttpStatus.OK);
	}

	@GetMapping("/getcheapfilghtinfo")
	public ResponseEntity<String> getFlightInfo() throws IOException {

		URL url = new URL(
				"https://api-crt.cert.havail.sabre.com/v1/shop/flights/cheapest/fares/LAX?pointofsalecountry=US");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Authorization",
				"Bearer T1RLAQKHMrcmvNQI4l3JQ55xWc077fuKdBDK/YU/6eXPZQOleQ08NzW7AADAfpYi1GXqhHV4mT7j1ZkmVOA/krzaEA0AZRzqaPbz27wCI+TVt5o6PMRMaJbkdtED/Q4gfG5JalmJXvIamiHcZ/WV2J4IbKEjUIPMM1xIYyOnPqeYS5DgUcip1HY0HeEhzi0ytC8nQnLk9jzDCxpAdfynvnu+bxkqE/Dj7NuG8ovtY2S7psPA0v3lf9cYR2zRl7SmtV7+Ce9/za295eEJw7eSuCeMMwB8Ygfe2Se+m5nyJyVEli0OkPrJl/qQgtGw");

		int responseCode = connection.getResponseCode();
	//	System.out.println("Get Response Code :: " + responseCode);
		StringBuffer response = new StringBuffer();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} 

		return new ResponseEntity<>(response.toString(), HttpStatus.OK);
	}

}
