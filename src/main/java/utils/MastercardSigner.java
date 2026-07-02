package utils;

import com.mastercard.developer.oauth.OAuth;
import com.mastercard.developer.utils.AuthenticationUtils;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;

public class MastercardSigner {

    public static String getAuthHeader(String url, String method, String payload) throws Exception {
        
        String keyPath = "src/test/resources/certs/mastercard.p12"; 
        String keyAlias = "mastercard_key"; 
        
        String keyPassword = System.getProperty("keystore.password"); 
        if (keyPassword == null) {
            keyPassword = "dummy_password";
        }
        
        String consumerKey = "9DgWjkjh2htFtYYTDYjmzrSo7bPjIr4DBSYTjJaw46b46d58!7df11572823845d896ee48d30664a75f0000000000000000";

        PrivateKey signingKey = AuthenticationUtils.loadSigningKey(keyPath, keyAlias, keyPassword);
        
        return OAuth.getAuthorizationHeader(URI.create(url), method, payload, StandardCharsets.UTF_8, consumerKey, signingKey);
    }
}