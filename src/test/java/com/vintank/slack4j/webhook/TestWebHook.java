/**
 * Copyright (C) 2014 James Jory (james@vintank.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
