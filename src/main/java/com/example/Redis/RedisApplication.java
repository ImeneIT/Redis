package com.example.Redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@SpringBootApplication
@EnableCaching
public class RedisApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(RedisApplication.class, args);
		// Configure and start WireMock server
		WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8082));
		wireMockServer.start();
		WireMock.configureFor("localhost", 8082);

		AuditLogin auditLogin = new AuditLogin();
		auditLogin.setApplicationVersion("3.0.7");
		auditLogin.setClientIPAddress(null);
		auditLogin.setConstructor("Apple");
		auditLogin.setDeviceId("FF8AF161-0B41-48C8-86B9-CFA3BD5B9589");
		auditLogin.setJailBreakIndicator("false");
		auditLogin.setOsUsed("Android");
		auditLogin.setOsVersion("14.7.1");

		// Create and populate the LoginRequest object
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setAuditLogin(auditLogin);
		loginRequest.setLogin("1077557157");
		loginRequest.setPassword("060102");
		// Convert the LoginRequest object to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String inputJson = objectMapper.writeValueAsString(loginRequest);

		// Set up mock responses for POST request
		String outputJson = "{\n" +
				"    \"accessToken\": \"eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJhMTQ3b3VUN25Sb0JIb3BRWVFPa29HTVNqZklwWllGdGdwTEI0NElnalJNIn0.eyJleHAiOjE3MTY4MTgyNzYsImlhdCI6MTcxNjgxNzk3NiwianRpIjoiZTQ0MDBjOWItNjBjOC00MjJmLWE1NDMtNmUzODU3MDVlN2NiIiwiaXNzIjoiaHR0cHM6Ly9zc29jb25uZWN0LmlyYi1yYS5pbnQuc3RhZ2luZy5lY2hvbmV0L2F1dGgvcmVhbG1zL2R6IiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImY6ODk2OGMyZTItZTY2Ny00OWQzLWE3YTAtZmJmNGFkMzZlYjJlOjEwNzc1NTcxNTciLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhcHAtbWJhbmtpbmciLCJzZXNzaW9uX3N0YXRlIjoiMTdlOGM2MTAtODBjMi00NWFmLTg1Y2QtYmY4YTUwM2EwMWRkIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6IiIsInNpZCI6IjE3ZThjNjEwLTgwYzItNDVhZi04NWNkLWJmOGE1MDNhMDFkZCIsIkREX01BSiI6IjE3MTE2NDIxNDkwMDAiLCJjZm1wIjoiRiIsInByZWZlcnJlZF91c2VybmFtZSI6IjEwNzc1NTcxNTciLCJjcl9jIjoiMTA3NzU1NzE1NyJ9.W1Z4187rDG5Cl-8o-Sjd-xC_OaQIz6Dk2ObhJH8F8rP4vQQXGSQbR09vasJEc8Dj41Sdwvn4WwbyOYh8ot0-PD8flkETJlNwMPePmjsEQBeplMEmRfsxOG7i_1Qjthw_5iq6y0c8k_7ltOyKs6EeIGEze-uToCd0b0RBSCdLZQaeYnNFy8MkUXauxOn9j_vWOQNbE33txRCp3c6gwrxwspV0xY-TBDrtogXt2TkTJrSWOP4ilfqhTVvWGl6VKu3a0AmU9cLTHuqJ7lwxvL6FObkAhazxk2cEZOPZeLKW-d1kP2CF1jbQe7WWFNADsOGhq-llug63ElF-t14xE8LUfg\",\n" +
				"    \"refreshToken\": \"eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI5NTMxMmNhYS00ODcwLTQ2ODgtODI3OC0wNDIyMTA3ZGY1NTUifQ.eyJleHAiOjE3MTY4MTk3NzYsImlhdCI6MTcxNjgxNzk3NiwianRpIjoiODljOWE5NzMtYjMyYS00ZTBiLWJkZWEtZjlmYTMzZjI2MWIxIiwiaXNzIjoiaHR0cHM6Ly9zc29jb25uZWN0LmlyYi1yYS5pbnQuc3RhZ2luZy5lY2hvbmV0L2F1dGgvcmVhbG1zL2R6IiwiYXVkIjoiaHR0cHM6Ly9zc29jb25uZWN0LmlyYi1yYS5pbnQuc3RhZ2luZy5lY2hvbmV0L2F1dGgvcmVhbG1zL2R6Iiwic3ViIjoiZjo4OTY4YzJlMi1lNjY3LTQ5ZDMtYTdhMC1mYmY0YWQzNmViMmU6MTA3NzU1NzE1NyIsInR5cCI6IlJlZnJlc2giLCJhenAiOiJhcHAtbWJhbmtpbmciLCJzZXNzaW9uX3N0YXRlIjoiMTdlOGM2MTAtODBjMi00NWFmLTg1Y2QtYmY4YTUwM2EwMWRkIiwic2NvcGUiOiIiLCJzaWQiOiIxN2U4YzYxMC04MGMyLTQ1YWYtODVjZC1iZjhhNTAzYTAxZGQifQ.6sArawUbH3pk9ZS0ZMXqQaPv5-27RFXL1Hr-w5K14mE\"\n" +
				"}";

		WireMock.stubFor(post(WireMock.urlEqualTo("/api/test"))
				.withHeader("Content-Type", equalTo("application/json"))
				.withRequestBody(equalToJson(inputJson))
				.willReturn(aResponse()
						.withHeader("Content-Type", "application/json")
						.withBody(outputJson)));

		// Your application code to consume the mocked API
		ApiService apiService = new ApiService();
		String response = apiService.sendPostRequest(loginRequest);
		System.out.println("Mocked API Response: " + response);
		// Set up mock responses for POST request
//		WireMock.stubFor(post(WireMock.urlEqualTo("/api/test"))
//				.withHeader("Content-Type", WireMock.equalTo("application/json"))
//				.willReturn(aResponse()
//						.withHeader("Content-Type", "application/json")
//						.withBody("{ \"message\": \"Hello, WireMock!\" }")));

		// Your application code to consume the mocked API
//		ApiService apiService = new ApiService();
//		String requestJson = "{ \"name\": \"test\" }";
//		String response = apiService.sendPostRequest(requestJson);
//		System.out.println("Mocked API Response: " + response);

		// Stop WireMock server
		wireMockServer.stop();
	}

}
