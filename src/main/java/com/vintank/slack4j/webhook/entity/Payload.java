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
package com.vintank.slack4j.webhook.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload {
	private String text;
	private String channel;
	private String username;
	@JsonProperty("icon_url")
	private String iconUrl;
	@JsonProperty("icon_emoji")
	private String iconEmoji;
	private List<Attachment> attachments;
	
	Payload() {
	}
	
	public Payload(String text) {
		this.text = text;
	}

	public static Payload instance(String text) {
		return new Payload(text);
	}
	
	public Payload text(String text) {
		setText(text);
		return this;
	}
	
	public Payload channel(String channel) {
		setChannel(channel);
		return this;
	}
	
	public Payload username(String username) {
		setUsername(username);
		return this;
	}
	
	public Payload iconUrl(String url) {
		setIconUrl(url);
		return this;
	}
	
	public Payload iconEmoji(String emoji) {
		setIconEmoji(emoji);
		return this;
	}

	public Payload attachments(Attachment... attachments) {
		if (this.attachments == null)
			this.attachments = new ArrayList<Attachment>(Arrays.asList(attachments));
		else
			this.attachments.addAll(Arrays.asList(attachments));
		return this;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconEmoji = null;
		this.iconUrl = iconUrl;
	}

	public String getIconEmoji() {
		return iconEmoji;
	}

	public void setIconEmoji(String iconEmoji) {
		this.iconUrl = null;
		this.iconEmoji = iconEmoji;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void addAttachment(Attachment attachment) {
		if (attachments == null)
			attachments = new ArrayList<Attachment>(3);
		attachments.add(attachment);
	}
	
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
}
