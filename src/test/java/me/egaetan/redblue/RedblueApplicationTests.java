package me.egaetan.redblue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RedblueApplicationTests {

	final static int port = Integer.parseInt(System.getProperty("port", "9080"));
	HttpClient client = HttpClient.newHttpClient();
	String uri = "http://localhost:" + port;

	@Test
	void sqdkqsmdf() throws IOException, InterruptedException {
		// GIVEN
		HttpRequest red = HttpRequest.newBuilder()
				.uri(URI.create(uri + "/red"))
				.build();
		//client.send(red, BodyHandlers.ofString());

		// WHEN
		ExecutorService pool = Executors.newFixedThreadPool(8);
		for (int i = 0; i < 1000; i++) {
			pool.execute(() -> {
				try {
					client.send(red, BodyHandlers.ofString());
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		pool.shutdown();
		pool.awaitTermination(1, TimeUnit.MINUTES);
		
		// THEN
		HttpResponse<String> response1001 = client.send(red, BodyHandlers.ofString());
		Assertions.assertThat(response1001.body()).isEqualTo("{\"message\":\"1001/0\"}");
	}

	@BeforeEach
	void init() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(uri + "/reset"))
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		Assertions.assertThat(response.body()).isEqualTo("{\"message\":\"TIE\"}");
	}
	
}
