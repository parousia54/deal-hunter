package com.pinkdroid.dealshunter.util;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class YelpReviewsRetriever extends AsyncTask<String, Object, String> {
	
	@Override
	protected void onPreExecute() {
	}

	@Override
	protected String doInBackground(String... params) {
		String serverUrl = params[0];
		URL url;
		HttpURLConnection urlConnection;
		InputStream is;
		StringBuffer sb;
		int chr;
		try {
			url = new URL(serverUrl);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setConnectTimeout(15 * 1000); //15 seconds
			urlConnection.connect();
			if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				is = urlConnection.getInputStream();
				sb = new StringBuffer();
				while ((chr = is.read()) != -1) {
					sb.append((char) chr);
				}
				return sb.toString();
			} else {
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		if (result != null) {
			String responseStr = (String) result;
			System.out.println(responseStr);
		}
	}
}
