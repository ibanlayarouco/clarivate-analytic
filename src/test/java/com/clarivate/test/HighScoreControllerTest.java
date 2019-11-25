package com.clarivate.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HighScoreControllerTest {
	@Autowired
	private MockMvc mvc;
	String token;
    public static final String USER2 = "{ \"username\": \"user2\", \"password\": \"password2\" }";

    public MultiValueMap<String, String> getUserMap(String username, String password) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        params.add("password", password);
        
        return params;
    }    
    
    @BeforeAll
    public void init() throws Exception {
    	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/login")
        		.contentType(MediaType.APPLICATION_JSON).content(USER2)).andReturn();    
    	token = mvcResult.getResponse().getHeader("Authorization");
    }	
	
	@Test
	public void findHighScoreByUserAndLevl() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/level/1/score").header("Authorization", token)).andExpect(status().isOk());
	}
	
	@Test
	public void putLevelScore() throws Exception {
		mvc.perform(MockMvcRequestBuilders.put("/level/1/score/12").header("Authorization", token)).andExpect(status().isNoContent());
	}	
	
}
