package com.vintank.slack4j.webhook;

import java.io.InputStream;
import java.util.Properties;

import junit.framework.TestCase;

/**
 * Base class for integration testing of Slack WebHook.
 * 
 * @author jamesjory
 */
public abstract class TestBase extends TestCase {
	protected final Properties props = new Properties();

	public TestBase() {
		super();
	}

	public TestBase(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		InputStream is = TestBase.class.getResourceAsStream("/test.properties");
		if (is == null)
			throw new IllegalStateException("Does your test.properties file exist?");
		
        props.load(is);
        is.close();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	protected SlackWebHook createWebHook() {
		String url = props.getProperty("slack.url");
		if (url == null)
			throw new IllegalStateException("slack.url property not found in test.properties");
		
		return new SlackWebHook(url);
	}
	
	protected String getChannel() {
		return props.getProperty("slack.channel");
	}
}
