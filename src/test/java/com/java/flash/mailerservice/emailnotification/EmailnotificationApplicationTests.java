package com.java.flash.mailerservice.emailnotification;

import com.java.flash.mailerservice.emailnotification.domain.MailModel;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = EmailnotificationApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmailnotificationApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testSendEmailNotification() {
		MailModel mailModel = new MailModel();

		mailModel.setEmailId("receiver@flash.co.za");
		mailModel.setSubject("Mail Subject");
		mailModel.setMessage("Mail Message");

		ResponseEntity<MailModel> postResponse = restTemplate.postForEntity( getRootUrl() + "/sendMail", mailModel, MailModel.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
}
