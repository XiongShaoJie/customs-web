package com.customs.configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfiguration {

    public TransportClient client(String host, int port, String clusterName) throws UnknownHostException {
	InetAddress inetAddress = InetAddress.getByName(host);
	InetSocketTransportAddress transportAddress = new InetSocketTransportAddress(inetAddress, port);
	TransportClient client = null;
	if (StringUtils.isBlank(clusterName)) {
	    client = new PreBuiltTransportClient(Settings.EMPTY);
	} else {
	    Settings settings = Settings.builder().put("cluster.name", clusterName).build();
	    client = new PreBuiltTransportClient(settings);
	}
	client.addTransportAddress(transportAddress);
	return client;
    }
}
