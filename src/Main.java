import dados.ConexaoDB;
import models.Url;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        var conexao = ConexaoDB.conector();
        if (conexao == null) {
            throw new SQLException("Erro ao conectar com o banco de dados");
        }
        System.out.println("Conexão estabelecida!");
        System.out.println("Bem vindo ao encurtador de URL!");
        System.out.println("Entre com a URL: ");

        Scanner scanner = new Scanner(System.in);

        String urlLong = scanner.nextLine();
        Url urlShort = new Url(urlLong);

        ResultSet resultSet = null;

        try {
            Statement statement = conexao.createStatement();
            String sql = "INSERT INTO shorten_table (token, long_url, created_at) VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, urlShort.getToken());
            preparedStatement.setString(2, urlShort.getUrl());
            preparedStatement.setString(3, urlShort.getCreatedAt().toString());
            preparedStatement.execute();
            System.out.println(sql.toString());

            System.out.println("Sua nova URL é: " + urlShort.geraShortUrl());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexao.close();
        }
    }
}