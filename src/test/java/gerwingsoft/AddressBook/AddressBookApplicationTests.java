package gerwingsoft.AddressBook;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressBookApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void createAddress() throws Exception {
		this.mockMvc.perform(get("/createAddressBook")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"id\":4,\"buddyInfoList\":[]}")));
	}

	@Test
	public void testAddressField() throws Exception {
		this.mockMvc.perform(get("/createAddressBook"));
		this.mockMvc.perform(get("/addBuddyInfo?bookId=4&name=\"d\"&phoneNumber=\"3\"&address=\"123lane\"")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("\"address\":\"\\\"123lane\\\"\"")));
	}
}
