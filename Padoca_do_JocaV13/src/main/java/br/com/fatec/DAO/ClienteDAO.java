package br.com.fatec.DAO;

import br.com.fatec.model.Cliente;
import br.com.fatec.persistencia.Banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ClienteDAO implements DAO<Cliente> {
    private java.sql.PreparedStatement pst;
    private java.sql.ResultSet rs;
    
    private Cliente cliente;
    
    @Override
    public boolean insere(Cliente obj) throws SQLException {
        String sql = "INSERT INTO Cliente (cpf, nome, email, celular, cep, rua, bairro, cidade, uf) " +
                     " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Cliente com o comando INSERT
        pst.setString(1, obj.getCpf());
        pst.setString(2, obj.getNome());
        pst.setString(3, obj.getEmail());
        pst.setString(4, obj.getCelular());
        pst.setString(5, obj.getCep());
        pst.setString(6, obj.getRua());
        pst.setString(7, obj.getBairro());
        pst.setString(8, obj.getCidade());
        pst.setString(9, obj.getUf());
        
        int res = pst.executeUpdate(); //esse metodo serve para INSERT, DELETE e UPDATE
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public boolean remove(Cliente obj) throws SQLException {
        String sql = "DELETE FROM Cliente WHERE cpf = ?";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Cliente com o comando DELETE
        pst.setString(1, obj.getCpf());
        
        int res = pst.executeUpdate();
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public boolean altera(Cliente obj) throws SQLException {
        String sql = "UPDATE Cliente SET nome = ? , "
                   + "email = ? , "
                   + "celular = ? , "
                   + "cep = ? , "
                   + "rua = ? , "
                   + "bairro = ? , "
                   + "cidade = ? , "
                   + "uf = ? "
                   + "WHERE cpf = ?";
        
        Banco.conectar();
       
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Cliente com o comando UPDATE
        pst.setString(9, obj.getCpf());
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getEmail());
        pst.setString(3, obj.getCelular());
        pst.setString(4, obj.getCep());
        pst.setString(5, obj.getRua());
        pst.setString(6, obj.getBairro());
        pst.setString(7, obj.getCidade());
        pst.setString(8, obj.getUf());
        
        int res = pst.executeUpdate(); 
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public Cliente buscaID(Cliente obj) throws SQLException {
        String sql = "SELECT * FROM Cliente "
                   + "WHERE cpf = ?";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        pst.setString(1, obj.getCpf());
        
        rs = pst.executeQuery(); //esse metodo serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do proximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            cliente = new Cliente();
            cliente.setCpf(rs.getString("cpf"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setCep(rs.getString("cep"));
            cliente.setRua(rs.getString("rua"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setUf(rs.getString("uf"));
        }
        else {
            //nao encontrou o registro solicitado
            cliente = null;
        }
                
        Banco.desconectar();
        
        //devolve o objeto cliente
        return cliente;
    }
    
    @Override
    public Collection<Cliente> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Cliente> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Cliente ";

        //precisa fazer filtro para listagem
        if(criterio != null && criterio.length() > 0) {
            sql += " WHERE " + criterio;
        }
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        while(rs.next()) {
            //criar o objeto
            cliente = new Cliente();
            
            cliente.setCpf(rs.getString("cpf"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setCelular(rs.getString("celular"));
            cliente.setCep(rs.getString("cep"));
            cliente.setRua(rs.getString("rua"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setUf(rs.getString("uf"));
            
            //move o objeto para a colecao
            lista.add(cliente);
        }
                
        Banco.desconectar();
        
        return lista;   
    }
}
