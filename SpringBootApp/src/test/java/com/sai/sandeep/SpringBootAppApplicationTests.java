package com.sai.sandeep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sai.sandeep.SpringBootAppApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAppApplication.class)
@WebAppConfiguration
public class SpringBootAppApplicationTests {

	@Test
	public void contextLoads() {
	}

}
