package pl.inpost.home.task.config;

public class Config {
    public static final String BASE_API_URL = System.getenv("BASE_API_URL");

    public static String getBaseApiUrl() {
        if (BASE_API_URL == null || BASE_AP_URL.isEmpty()) {
            return "https://api.inpost.pl/v1";
        }
        return BASE_API_URL;
    }

    private static final String API_KEY = System.getenv("API_KEY");

    public static String getApiKey() {
        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new IllegalStateException("API_KEY is not set. Please provide it in Docker Compose.");
        }
        return API_KEY;
    }

	 public static final String BASE_UI_URL = System.getenv("BASE_UI_URL");

    public static String getBaseUI() {
        if (BASE_UI_URL == null || BASE_UI_URL.isEmpty()) {
            return "https://api.inpost.pl/v1";
        }
        return BASE_UI_URL;
    }
}
