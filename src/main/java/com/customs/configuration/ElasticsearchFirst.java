package com.customs.configuration;

import java.net.UnknownHostException;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticsearchFirst extends ElasticsearchConfiguration {
    private String url;
    private int port;

    public String getUrl() {
	return url;
    }

    @Bean
    public TransportClient createClient() throws UnknownHostException {
	return client(url, port, null);
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

}
