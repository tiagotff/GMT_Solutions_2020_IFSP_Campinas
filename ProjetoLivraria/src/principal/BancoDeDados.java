package principal;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class BancoDeDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public void conectar(){
		String servidor = "jdbc:mysql://localhost:3307/projeto_livraria";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = (Connection) DriverManager.getConnection(servidor, usuario, senha);
			this.statement = (Statement) this.connection.createStatement();
		}catch (Exception e) {
			System.out.println("Erro :" + e.getMessage());
		}
	}
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	//SALVAR COMO LIVRO (listarLivros)
	public void listarContatos() {
		try {
			String query = "SELECT * FROM livro ORDER BY nm_livro";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()) {
				System.out.println("ID: " + this.resultSet.getString("cd_livro") + " - NOME: " + this.resultSet.getString("nm_livro"));
				
			}
		}catch(Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	
	}
	
	public void inserirLivro(int cd_livro, String nm_livro, String autor, String editora, String genero, int ano_livro, int edicao, double preco_venda, int qnt_livro, int cd_fornecedor, String link_img) {
		try {
			String query = "INSERT INTO livro VALUES ('" + cd_livro +"''" + nm_livro +"' '" + autor +"' '" + editora +"' '" + genero + "' '" + ano_livro + "' '" + edicao + "' '" + preco_venda +"' '" + qnt_livro + "' '" + cd_fornecedor + "' '" + link_img + "');";
			System.out.println(query);
			this.statement.executeUpdate(query);
		}catch(Exception e){
			System.out.println("ERRO: "+ e.getMessage());
		}
	}
	
	
	
	
}
