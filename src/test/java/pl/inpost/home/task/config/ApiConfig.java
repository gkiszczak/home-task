package pl.inpost.home.task.config;

public class ApiConfig {
    public static final String BASE_URL = System.getenv("BASE_URL");

    public static String getBaseUrl() {
        if (BASE_URL == null || BASE_URL.isEmpty()) {
            return "https://api.inpost.pl/v1";
        }
        return BASE_URL;
    }

    public static final String POINTS_ENDPOINT = "/points";

    private static final String API_KEY = System.getenv("API_KEY");

    public static String getApiKey() {
        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new IllegalStateException("API_KEY is not set. Please provide it in Docker Compose.");
        }
        return API_KEY;
    }
}
