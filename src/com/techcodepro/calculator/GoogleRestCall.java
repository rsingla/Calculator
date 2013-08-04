package com.techcodepro.calculator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.StrictMode;

import com.google.gson.Gson;

public class GoogleRestCall {
	
	
	public String callGoogle(String spinner1Val,String spinner2Val, Double doubleVal ) {
		String URL = "http://www.google.com/ig/calculator?hl=en&q="+doubleVal+
				spinner1Val+"+="+spinner2Val;
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
		
		String result = null;
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = null;
		try {
			response = httpclient.execute(new HttpGet(URL));

			StatusLine statusLine = response.getStatusLine();
			if(statusLine.getStatusCode() == HttpStatus.SC_OK){
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.getEntity().writeTo(out);
				out.close();
				 
				GoogleJsonObj conversionResponse = new Gson().fromJson(out.toString(), GoogleJsonObj.class);
				result = conversionResponse.getRhs().replaceAll("[^a-zA-Z0-9.\" \"]+","");
				
			} else{
				response.getEntity().getContent().close();
				throw new IOException(statusLine.getReasonPhrase());
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
