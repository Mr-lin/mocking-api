package com.mockst.mocking;

import com.mockst.mocking.module.user.entity.UserEntity;
import com.mockst.mocking.module.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockingApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		UserEntity user = new UserEntity();
		user.setUsername("ssss");
		userService.save(user);
		System.out.println(user.getId());
	}

}
