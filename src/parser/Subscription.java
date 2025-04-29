package parser;

public class Subscription {
    private String url;
    private String urlType;

    // Constructor
    public Subscription(String url, String urlType) {
        this.url = url;
        this.urlType = urlType;
    }

    // Getters
    public String getUrl() {
        return url;
    }

    public String getUrlType() {
        return urlType;
    }
}
