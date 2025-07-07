package boot.day0703.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan("data.thyme.dto")
class ThymeleafTestApplicationTests {

	@Test
	void contextLoads() {
	}

}
