package models;

import java.sql.Timestamp;
import java.util.Random;

public class Url {

    private String token;
    private String url;
    private Timestamp createdAt;

    public Url(String url) {
        token = setToken(url);
        this.url = url;
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    public String getToken() {
        return token;
    }

    public String getUrl() {
        return url;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    private String setToken(String url) {
        String enderecoPrincipal = url.split("\\.")[1];
        System.out.println(enderecoPrincipal);
        char[] enderecoPrincipalChar = enderecoPrincipal.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < enderecoPrincipalChar.length; i++) {
            stringBuilder.append(enderecoPrincipalChar[random.nextInt(enderecoPrincipalChar.length - 1)]);
            stringBuilder.append(random.nextInt(enderecoPrincipalChar.length));
        }

        token = stringBuilder.toString();
        return token;
    }

    public String geraShortUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://localhost:8080?token=");
        stringBuilder.append(token);

        return stringBuilder.toString();
    }
}
