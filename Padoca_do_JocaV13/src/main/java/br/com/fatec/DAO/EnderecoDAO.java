package br.com.fatec.DAO;

import br.com.fatec.model.Endereco;
import br.com.fatec.persistencia.Banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class EnderecoDAO implements DAO<Endereco> {
    private java.sql.PreparedStatement pst;
    private java.sql.ResultSet rs;
    
    private Endereco endereco;
    
    @Override
    public boolean insere(Endereco obj) throws SQLException {
        String sql = "INSERT INTO Endereco (cep, rua, bairro, cidade, uf) " +
                     " VALUES (?, ?, ?, ?, ?)";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Endereco com o comando INSERT
        pst.setString(1, obj.getCep());
        pst.setString(2, obj.getRua());
        pst.setString(3, obj.getBairro());
        pst.setString(4, obj.getCidade());
        pst.setString(5, obj.getUf());
        
        int res = pst.executeUpdate(); //esse metodo serve para INSERT, DELETE e UPDATE
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public boolean remove(Endereco obj) throws SQLException {
        String sql = "DELETE FROM Endereco WHERE cep = ?";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Endereco com o comando DELETE
        pst.setString(1, obj.getCep());
        
        int res = pst.executeUpdate();
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public boolean altera(Endereco obj) throws SQLException {
        String sql = "UPDATE Endereco SET rua = ? , "
                   + "bairro = ? , "
                   + "cidade = ? , "
                   + "uf = ? "
                   + "WHERE cep = ?";
        
        Banco.conectar();
       
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Endereco com o comando UPDATE
        pst.setString(5, obj.getCep());
        pst.setString(1, obj.getRua());
        pst.setString(2, obj.getBairro());
        pst.setString(3, obj.getCidade());
        pst.setString(4, obj.getUf());
        
        int res = pst.executeUpdate(); 
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public Endereco buscaID(Endereco obj) throws SQLException {
        String sql = "SELECT * FROM Endereco "
                   + "WHERE cep = ?";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        pst.setString(1, obj.getCep());
        
        rs = pst.executeQuery(); //esse metodo serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do proximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            endereco = new Endereco();
            endereco.setCep(rs.getString("cep"));
            endereco.setRua(rs.getString("rua"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setUf(rs.getString("uf"));
        }
        else {
            //nao encontrou o registro solicitado
            endereco = null;
        }
                
        Banco.desconectar();
        
        //devolve o objeto endereco
        return endereco;
    }
    
    @Override
    public Collection<Endereco> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Endereco> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Endereco ";

        //precisa fazer filtro para listagem
        if(criterio != null && criterio.length() > 0) {
            sql += " WHERE " + criterio;
        }
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        while(rs.next()) {
            //criar o objeto
            endereco = new Endereco();
            
            endereco.setCep(rs.getString("cep"));
            endereco.setRua(rs.getString("rua"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setUf(rs.getString("uf"));
            
            //move o objeto para a colecao
            lista.add(endereco);
        }
                
        Banco.desconectar();
        
        return lista;   
    }
}
