package test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class Test {

	public static void main(String[] args) {

		try {
			Client client = Client.create();
			System.out.println("df");

			WebResource webResource = client
					.resource("http://localhost:8080/RestProject/Rest/locationService/locationInsert");

			String input = "{\"login\":\"Teste2\",\"latitude\":20.2\"longitude\":21.63}";

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}

