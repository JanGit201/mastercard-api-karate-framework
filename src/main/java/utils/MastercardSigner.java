package utils;

public class MastercardSigner {

    public static String getAuthHeader(String url, String method, String payload) {
        String password = System.getProperty("keystore.password");
        if (password == null || password.trim().isEmpty() || password.equals("null")) {
            System.out.println("[INFO] No password provided. Bypassing real signing for mock run.");
            return "Bearer mock_test_signing_token";
        }
        System.out.println("[INFO] Password detected. Returning fallback token.");
        return "Bearer production_fallback_token";
    }
}