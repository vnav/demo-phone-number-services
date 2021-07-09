package com.testCompany.demo.service;

import static org.springframework.test.context.jdbc.SqlConfig.TransactionMode.ISOLATED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@Sql(scripts={"/db/test-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts={"/db/cleanup.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, config = @SqlConfig(transactionMode = ISOLATED)) 
public class CustomerPhoneServiceTest {
	@Autowired
	private MockMvc mockMvc;

	
	@Test
	public void getAllPhone_returnsListOfPhoneNumbers() throws Exception {
		System.out.println(mockMvc==null);
		mockMvc.perform(get("/demo/customers/accounts/phoneNumbers")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(14))
				.andExpect(status().is2xxSuccessful());
	}
	
	
	@Test
	public void getCustomerPhone_returnsListOfPhoneNumbersForCustomer() throws Exception {
		System.out.println(mockMvc==null);
		mockMvc.perform(get("/demo/customers/{customerId}/phoneNumbers", 11)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void activatePhone_returnsPhoneNumberWithActivatedStatus() throws Exception {
		System.out.println(mockMvc==null);
		mockMvc.perform(get("/demo/customers/{activationCode}/activate", 10000)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("ACTIVE"))
				.andExpect(status().is2xxSuccessful());
	}

	
}
