package max.general;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class StatusCode {
	
	private static TrustManager[] trustAllCerts;
	
	public static void getStatusCode(String url) {
		trustedManager();
		sslCertificate();
	}
	
	private static void trustedManager() {
		trustAllCerts = new TrustManager[] { 
		    (TrustManager) new X509TrustManager() {     
		        public X509Certificate[] getAcceptedIssuers() { 
		            return new X509Certificate[0];
		        } 
		        public void checkClientTrusted( 
		            X509Certificate[] certs, String authType) {
	            } 
		        public void checkServerTrusted( 
		            X509Certificate[] certs, String authType) {
		        }
		    } 
		};
	}
	
	private static void sslCertificate() {
		try {
			SSLContext sc = SSLContext.getInstance("SSL"); 
		    sc.init(null, trustAllCerts, new SecureRandom()); 
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} 
		catch (GeneralSecurityException e) {}
	}
	
	public static void checkServerStatus(String url) {
		
	}
}