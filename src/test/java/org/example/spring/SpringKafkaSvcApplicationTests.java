package org.example.spring;

import org.example.JUnitTestUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaSvcApplicationTests {
	private final JUnitTestUtil testUtil = new JUnitTestUtil();
	@Test
	public void publishToKafka()  {

		String message="Hello, KAFKA!!";
		String url ="/kafka/publish?message=" + message;
		String body = testUtil.executePostRequest(url,null);

	}

}
