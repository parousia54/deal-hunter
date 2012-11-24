package com.pinkdroid.dealshunter.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import android.util.Log;

public abstract class NetworkManagerImpl implements NetworkManager{
	public static final int THREAD_TIMEOUT = 30000;
	public static final int MAX_CONNECTIONS = 16;

	// standard timeout values for single HTTP or WS
	public static final int STANDARD_SOCKET_TIMEOUT = 10000;
	public static final int STANDARD_CONNECTION_TIMEOUT = 10000;
	public static final int STANDARD_MAX_IDLE_TIME = 10000;

	// timeout values if connection is to be retried
	public static final int RETRY_SOCKET_TIMEOUT = 10000;
	public static final int RETRY_CONNECTION_TIMEOUT = 10000;

	protected final int INTERVAL = 250;
	protected long DELAY = 0;
	protected ThreadSafeClientConnManager connectionManager;
	protected HttpClient httpclient;
	private static int HTTP_PORT_80 = 80;
	/** This HTTP PORT is also used by Roy Morgan */
	private static int HTTP_PORT_8080 = 8080;
	private static int HTTPS_PORT = 443;
	protected static final String TIME_PATERN = "yyyy-MM-dd HH:mm:ss SSS zzz";
	protected static final String SERVER_TIME_PATERN = "yyyy-MM-dd HH:mm:ss";
	protected static final String MILISECOND_PATERN = "SSS";	
	
	//"http://uat.reactoroperations.com/Service/getVideodata";
	public NetworkManagerImpl(){
		initClientConnection();
	}
	
	private void initClientConnection() {
		if (connectionManager == null) {			
			initConnectionParameters();			
			
		}
		else{
			// If the number of connections exceed the maximum number allowed
			// then reset the connection pool.
			if(connectionManager.getConnectionsInPool()==MAX_CONNECTIONS){
				connectionManager.shutdown();
				initConnectionParameters();				
			}
		}
		
	}
	private void initConnectionParameters(){
		HttpParams connParams = new BasicHttpParams();
		HttpProtocolParams.setVersion(connParams, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(connParams, HTTP.UTF_8);
		HttpProtocolParams.setUseExpectContinue(connParams, false);
		HttpConnectionParams.setTcpNoDelay(connParams, true);
		HttpConnectionParams.setStaleCheckingEnabled(connParams, false);			
		HttpConnectionParams.setConnectionTimeout(connParams,
				STANDARD_CONNECTION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(connParams,
				STANDARD_SOCKET_TIMEOUT);
		
		
		ConnManagerParams.setMaxTotalConnections(connParams,
				MAX_CONNECTIONS);
		ConnManagerParams.setMaxConnectionsPerRoute(connParams,
				new ConnPerRoute() {
					@Override
					public int getMaxForRoute(HttpRoute route) {
						return MAX_CONNECTIONS;
					}
				});
		ConnManagerParams.setTimeout(connParams, THREAD_TIMEOUT);
		SchemeRegistry schReg = new SchemeRegistry();
		schReg.register(new Scheme("http", PlainSocketFactory
				.getSocketFactory(), HTTP_PORT_80));
		
		/**This allow accept all certificate 
		  *http://www.virtualzone.de/2011-02-27/how-to-use-apache-httpclient-with-httpsssl-on-android/
		*/
		schReg.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), HTTPS_PORT));

		connectionManager = new ThreadSafeClientConnManager(connParams,
				schReg);
		
		httpclient = new DefaultHttpClient(connectionManager, connParams);
		
	}
	
	public void closeConnection() {	
		if (connectionManager != null) {
			connectionManager.closeExpiredConnections();
			connectionManager.shutdown();
			connectionManager = null;
		}
	}
	protected boolean terminateHttpRequest(HttpRequestBase httpRequest){
		try{
			if(!httpRequest.isAborted())
				httpRequest.abort();
			connectionManager.closeIdleConnections(STANDARD_MAX_IDLE_TIME, TimeUnit.MILLISECONDS);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	protected static String readInputStreamString(InputStream is) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(is));
		StringBuilder total = new StringBuilder();
		String line;
		while ((line = r.readLine()) != null) {
			total.append(line);		
		}
		is.close();
		return total.toString();
	}
}
