package mercadolivre;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CorsConfigTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testCorsHeadersPresent() throws Exception {
		mockMvc.perform(options("/api/produtos") //
				.header(HttpHeaders.ORIGIN, "http://localhost:5173") //
				.header(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD, "GET")) //
				.andExpect(status().isOk()) //
				.andExpect(header().string("Access-Control-Allow-Origin", "http://localhost:5173")) //
				.andExpect(header().string("Access-Control-Allow-Methods", Matchers.containsString("GET")));
	}
	
}