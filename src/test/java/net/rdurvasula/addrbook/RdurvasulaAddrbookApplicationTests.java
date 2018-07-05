package net.rdurvasula.addrbook;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import net.rdurvasula.addrbook.data.Contact;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RdurvasulaAddrbookApplication.class)
@WebAppConfiguration
@ContextConfiguration
public class RdurvasulaAddrbookApplicationTests {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("UTF-8"));

	private HttpMessageConverter mappingJackson2HttpMessageConverter;

	private Contact contact;
	
	private long contactId = 0;

	@Autowired
	private ContactRepository contactRepo;

	@Autowired
	private ContactController controller;

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	
	@Configuration
	@EnableAutoConfiguration
	public static class ContactConfig {
		@Bean
		public ContactController controller() {
			return new ContactController();
		}
	}

	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters) {
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().orElse(null);
		
		assertNotNull("the JSON message converter must not be NULL !", this.mappingJackson2HttpMessageConverter);
	}

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		contactRepo.deleteAll();
		this.contact = contactRepo.save(new Contact("Ganesh", "Sharma", "Mr", "XYZ", "Friends"));
		contactId = contact.getId();
	}

	@Test
	public void contactNotFound() throws Exception {
		Contact newContact = new Contact(null, null, null, null, null);
		mockMvc.perform(post("/myaddrbook/save").content(json(newContact)).contentType(contentType)).andExpect(status().isBadRequest());
	}
	
	@Test
	public void findContact() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/myaddrbook/"+String.valueOf(contactId)).contentType(contentType));
		ResultMatcher resultMatcher = jsonPath("$.id", is(new Long(contactId).intValue()));
		resultActions.andExpect(resultMatcher);
	}

	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMsg = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(0, MediaType.APPLICATION_JSON, mockHttpOutputMsg);
		return mockHttpOutputMsg.getBodyAsString();
	}
}

