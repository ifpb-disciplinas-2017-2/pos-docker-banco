package br.edu.ifpb.infra;

import br.edu.ifpb.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/11/2017, 13:43:38
 */
public class PessoasJDBC {

    private Connection conexao;

    public List<Pessoa> todasAsPessoas() {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        preencherALista(pessoas);
        return pessoas;
    }

    private void iniciarConexao() {
        try {
            Class.forName("org.postgresql.Driver");
            //host-banco será utilizado para o link com o banco
            this.conexao = DriverManager.getConnection(
                    "jdbc:postgresql://host-banco:5432/pos-cliente",
                    "postgres", "12345");

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoasJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preencherALista(ArrayList<Pessoa> pessoas) {
        iniciarConexao();
        try {
            try (Statement statement = this.conexao.createStatement()) {
                ResultSet result = statement.executeQuery("Select * from pessoa order by id asc");
                while (result.next()) {
                    int id = result.getInt("id");
                    String nome = result.getString("nome");
                    String cpf = result.getString("cpf");
                    pessoas.add(Pessoa.of(id, nome, cpf));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoasJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
