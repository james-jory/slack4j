## slack4j

Java driver for the [Slack API](https://api.slack.com/).

Currently the Incoming WebHooks integration is the only one supported. Others may be added 
in the future as necessary.

## Incoming WebHooks

Posting messages to a Slack channel using the Incoming WebHook integration is simple.

```
try {
	// Your slack incoming webhook URL (obtained from integrations for your Slack account).
	String slackUrl = "...";
	SlackWebHook slack = new SlackWebHook(slackUrl);
	
	// Send a simple message, specifying an optional channel and username.
	slack.send(Payload.instance("Simple message").channel("#mychannel").username("slack4j-test"));
	
	// Sending a message with an attachment with fields is easy too.
	Payload payload = Payload.instance("Message with attachment")
			.channel("#mychannel")
			.iconEmoji(":sunny:")
			.username("slack4j-test")
			.attachments(Attachment.instance("This is fallback message")
				.color("good")
				.text("This is attachment text")
				.pretext("This is attachment pretext")
				.fields(
					Field.instance("Field1").value("Value1").isShort(true), 
					Field.instance("Field2").value("Value2").isShort(true)));

	slack.send(payload);	
}
catch (IOException e) {
	// Something went wrong.
}
``` 

## License

Copyright 2014 James Jory

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and
limitations under the License.