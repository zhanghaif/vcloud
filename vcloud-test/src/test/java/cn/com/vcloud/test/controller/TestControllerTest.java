package cn.com.vcloud.test.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TestControllerTest {

	@Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    
    /**
     * 初始化 MVC 的环境
     */
    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
	@Test
	public void testList() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/test")
                .contentType(MediaType.APPLICATION_JSON_UTF8))// accept response content type
                .andExpect(MockMvcResultMatchers.status().isOk()) // 期待返回状态吗码200
                .andDo(MockMvcResultHandlers.print()); // 打印返回的 http response 信息
	}
	
	@Test
	public void testGet() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/test/{id}",1)
        		.accept(MediaType.APPLICATION_JSON))
		        .andExpect(MockMvcResultMatchers.status().isOk())
		        .andDo(MockMvcResultHandlers.print())
		        .andReturn();
	}
	
	@Test
	public void testAdd() throws Exception{
		String json = "{\r\n" + 
				"	\"name\":\"test\",\r\n" + 
				"	\"age\":19,\r\n" + 
				"	\"address\":\"星火路4号\"\r\n" + 
				"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/test")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.getBytes()))
		.andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void testDelete() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/v1/test/{id}", 19)
				.accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
	}

}
