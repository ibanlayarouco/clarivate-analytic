package com.clarivate.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
public class WebSecurityTest {
   @Autowired
    private MockMvc mvc;
    
    public static final String BADUSER = "{ \"username\": \"user5\", \"password\": \"password1\" }";
    public static final String BADPASSWORD = "{ \"username\": \"user1\", \"password\": \"password1333\" }";
    public static final String USER1 = "{ \"username\": \"user1\", \"password\": \"password1\" }";
    
    public MultiValueMap<String, String> getUserMap(String username, String password) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        params.add("password", password);
        
        return params;
    }

    @Test
    public void shouldUnauhtorizedUser() throws Exception {
    	assertThrows(RuntimeException.class, () -> {
	        mvc.perform(MockMvcRequestBuilders.post("/login")
        		.contentType(MediaType.APPLICATION_JSON).content(BADUSER));     	
    	}, "Bad credentials");
    	
		assertThrows(RuntimeException.class, () -> {
	        mvc.perform(MockMvcRequestBuilders.post("/login")
	        		.contentType(MediaType.APPLICATION_JSON).content(BADPASSWORD));
	    }, "Bad credentials");     

    }
    
    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        //Unauthenticated user
    	mvc.perform(MockMvcRequestBuilders.get("/level/1/score")).andExpect(status().isUnauthorized());
    }
    
    @Test
    public void shouldValidAuth() throws Exception {
    	mvc.perform(MockMvcRequestBuilders.post("/login")
	        		.contentType(MediaType.APPLICATION_JSON).content(USER1)).andExpect(status().isAccepted());
    }
}
