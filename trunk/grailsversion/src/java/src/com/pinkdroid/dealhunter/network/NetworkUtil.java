package src.com.pinkdroid.dealhunter.network;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class NetworkUtil {

	private static final String API_KEY = ""; // TODO: put your API key here

	private void search(String query, String location) throws Exception {

		// construct url for the search endpoint
		URL searchUrl = new URL(
				"http://api.sensis.com.au/ob-20110511/test/search?key="
						+ API_KEY + "&query="
						+ URLEncoder.encode(query, "UTF-8") + "&location="
						+ URLEncoder.encode(location, "UTF-8"));

		// open connection to the server
		HttpURLConnection conn = (HttpURLConnection) searchUrl.openConnection();
		conn.connect();

		try {

			// ensure HTTP 200 (OK) response
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException(
						"Error calling Search API (HTTP status "
								+ conn.getResponseCode() + ")");
			}

			// grab the response stream
			InputStream stream = conn.getInputStream();

			// parse JSON response
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readValue(stream, JsonNode.class);

			// grab the reponse code and message
			int code = root.get("code").getIntValue();
			String message = root.get("message").getTextValue();

			// ensure successful status code
			switch (code) {
			case 200: // success
				break;
			case 206: // spell-checker was run
				System.out.println("Note: " + message);
				break;
			default:
				throw new RuntimeException("API returned error: " + message
						+ ", code: " + code);
			}

			System.out.println("Total results found: "
					+ root.get("totalResults").getIntValue());

			// iterate over the results
			for (JsonNode result : root.get("results")) {
				// print the business name and display address
				System.out.println(result.path("name").getTextValue()
						+ " ("
						+ result.path("primaryAddress").path("addressLine")
								.getTextValue() + ")");
			}

			stream.close();

		} finally {
			conn.disconnect(); // ensure we always close the connection
		}

	}

}
