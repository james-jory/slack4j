package com.vintank.slack4j.webhook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreProtocolPNames;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vintank.slack4j.webhook.entity.Payload;

public class SlackWebHook {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private final String url;
	
	public SlackWebHook(String url) {
		this.url = url;
	}
	
	public void send(String message) throws IOException {
		send(new Payload(message));
	}
	
	public void send(Payload payload) throws IOException {
		HttpPost post = new HttpPost(url);
		
		try {
			post.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "Slack4j/1.0");
			post.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, "UTF-8");
			
			HttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(AllClientPNames.CONNECTION_TIMEOUT, 5000);
			client.getParams().setParameter(AllClientPNames.SO_TIMEOUT, 5000);
			
			List<NameValuePair> nvps = new ArrayList<NameValuePair>(1);
	        nvps.add(new BasicNameValuePair("payload", MAPPER.writeValueAsString(payload)));
	
	        post.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
	
	        client.execute(post);
		}
		finally {
			post.releaseConnection();
		}
	}
}
