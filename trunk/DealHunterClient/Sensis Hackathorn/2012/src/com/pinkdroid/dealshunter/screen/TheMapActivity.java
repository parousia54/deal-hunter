package com.pinkdroid.dealshunter.screen;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

public class TheMapActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	private final class HttpWorker extends AsyncTask<String, Object, String> {
		ProgressDialog progressDialog;

		@Override
		protected void onPreExecute() {
			if (progressDialog == null) {
				progressDialog = ProgressDialog.show(getBaseContext(), null, "Getting reviews", true, true, new OnCancelListener() {
					@Override
					public void onCancel(DialogInterface dialog) {
						cancel(true);
					}
				});
			} else {
				progressDialog.show();
			}
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
			progressDialog.dismiss();
			if (result != null) {
				String responseStr = (String) result;
				System.out.println(responseStr);
			}
		}
	}
}
