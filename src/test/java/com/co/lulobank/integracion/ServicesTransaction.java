package com.co.lulobank.integracion;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.co.lulobank.dominio.modelo.transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.co.lulobank.CodeCallengeApplication;
import com.co.lulobank.transactionTestDataBuillder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CodeCallengeApplication.class)
@AutoConfigureWebMvc
public class ServicesTransaction {


	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	private  transactionTestDataBuillder data = new transactionTestDataBuillder();
	 
	@Before(value = "")
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	
	@Test
	public void registrerTransaction() throws Exception
	{
		transaction transactionData = data.build();
	     mvc.perform( MockMvcRequestBuilders
	      .post("/api/transaction")
	      .content(new ObjectMapper().writeValueAsString(transactionData))
	    		  .contentType(MediaType.APPLICATION_JSON))	
	    		  .andExpect(status().isCreated())
	    		  .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
	    	      .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	  }

	
}
