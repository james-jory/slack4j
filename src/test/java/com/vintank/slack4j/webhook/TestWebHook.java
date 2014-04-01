package com.vintank.slack4j.webhook;

import java.io.IOException;

import org.junit.Assert;

import com.vintank.slack4j.webhook.entity.Attachment;
import com.vintank.slack4j.webhook.entity.Field;
import com.vintank.slack4j.webhook.entity.Payload;

public class TestWebHook extends TestBase {
	public void testSimple() throws IOException {
		SlackWebHook slack = createWebHook();
		slack.send(Payload.instance("Simple message").channel(getChannel()).username("slack4j-test"));
		Assert.assertTrue(true);
	}
	
	public void testAttachment() throws IOException {
		Payload payload = Payload.instance("Message with attachment").channel(getChannel());
		payload.iconEmoji(":sunny:").username("slack4j-test");
		
		payload.attachments(Attachment.instance("This is fallback message")
				.color("good")
				.text("This is attachment text")
				.pretext("This is attachment pretext")
				.fields(Field.instance("Field1").value("Value1").isShort(true), Field.instance("Field2").value("Value2").isShort(true)));
		
		SlackWebHook slack = createWebHook();
		slack.send(payload);
		Assert.assertTrue(true);
	}
}
