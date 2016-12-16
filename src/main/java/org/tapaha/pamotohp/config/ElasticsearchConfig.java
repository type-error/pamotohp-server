package org.tapaha.pamotohp.config;

import java.net.InetSocketAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages="org.tapaha.pamotohp.repository")
public class ElasticsearchConfig {
	
	@Bean
	public Client client() {
		try {
			
			final Settings settings =
					Settings.settingsBuilder()
					.put("cluster.name", "pamotohp")
					.put("cluster.nodes", "localhost:9300")
					.put("client.transport.sniff", true).build();
			
			TransportClient client = TransportClient.builder().settings(settings)
					.build().addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("localhost", 9300)));
			
			return client;
			
		} catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	@Bean
	public ElasticsearchTemplate elasticsearchTemplate() {
		return new ElasticsearchTemplate(client());
	}
	
	private Client getTransportClient() {
		try {
			
			final Settings settings =
					Settings.settingsBuilder()
					.put("cluster.name", "es_test")
					.put("cluster.nodes", "localhost:9300")
					.put("client.transport.sniff", true).build();
			
			TransportClient client = TransportClient.builder().settings(settings).build();
			
			return client;
			
		} catch(Exception e) {
			throw new RuntimeException();
		}
	}
}
