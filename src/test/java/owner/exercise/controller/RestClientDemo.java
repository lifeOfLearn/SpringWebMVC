package owner.exercise.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestClient;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcherServlet.xml")
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestClientDemo {
	
	@Test
	public void restClientDemo() {

//		RestClient customClient = RestClient.builder()
//		  .requestFactory(new HttpComponentsClientHttpRequestFactory())
////		  .messageConverters(converters -> converters.add(new MyCustomMessageConverter()))
//		  .baseUrl("http://localhost:8080/mvc")
////		  .defaultUriVariables(Map.of("variable", "foo"))
//		  .defaultHeader("My-Header", "Foo")
//		  .defaultCookie("My-Cookie", "Bar")
////		  .requestInterceptor(myCustomInterceptor)
////		  .requestInitializer(myCustomInitializer)
//		  .build();
//		
//		customClient.get()
//					.uri("http://localhost:8080/mvc/cindex");
		
		RestClient defaultClient = RestClient.create();
		String url = "http://localhost:8080/mvc/cindex";
		String response = defaultClient.get()
										.uri(url)
										.retrieve()
										.body(String.class);
		System.out.println("create response: " + response);
	}
}
