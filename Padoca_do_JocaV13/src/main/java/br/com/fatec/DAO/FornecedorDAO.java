package br.com.fatec.DAO;

import br.com.fatec.model.Fornecedor;
import br.com.fatec.persistencia.Banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class FornecedorDAO implements DAO<Fornecedor> {
    private java.sql.PreparedStatement pst;
    private java.sql.ResultSet rs;
    
    private Fornecedor fornecedor;
    
    @Override
    public boolean insere(Fornecedor obj) throws SQLException {
        String sql = "INSERT INTO Fornecedor (cnpj, nome, telefone) " +
                     " VALUES (?, ?, ?)";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Fornecedor com o comando INSERT
        pst.setString(1, obj.getCnpj());
        pst.setString(2, obj.getNome());
        pst.setString(3, obj.getTelefone());
        
        int res = pst.executeUpdate(); //esse metodo serve para INSERT, DELETE e UPDATE
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public boolean remove(Fornecedor obj) throws SQLException {
        String sql = "DELETE FROM Fornecedor WHERE cnpj = ?";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Fornecedor com o comando DELETE
        pst.setString(1, obj.getCnpj());
        
        int res = pst.executeUpdate();
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public boolean altera(Fornecedor obj) throws SQLException {
        String sql = "UPDATE Fornecedor SET nome = ? , "
                   + "telefone = ? "
                   + "WHERE cnpj = ?";
        
        Banco.conectar();
       
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Fornecedor com o comando UPDATE
        pst.setString(3, obj.getCnpj());
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getTelefone());
        
        int res = pst.executeUpdate(); 
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public Fornecedor buscaID(Fornecedor obj) throws SQLException {
        String sql = "SELECT * FROM Fornecedor "
                   + "WHERE cnpj = ?";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        pst.setString(1, obj.getCnpj());
        
        rs = pst.executeQuery(); //esse metodo serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do proximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            fornecedor = new Fornecedor();
            fornecedor.setCnpj(rs.getString("cnpj"));
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setTelefone(rs.getString("telefone"));
        }
        else {
            //nao encontrou o registro solicitado
            fornecedor = null;
        }
                
        Banco.desconectar();
        
        //devolve o objeto fornecedor
        return fornecedor;
    }
    
    @Override
    public Collection<Fornecedor> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Fornecedor> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Fornecedor ";

        //precisa fazer filtro para listagem
        if(criterio != null && criterio.length() > 0) {
            sql += " WHERE " + criterio;
        }
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        while(rs.next()) {
            //criar o objeto
            fornecedor = new Fornecedor();
            
            fornecedor.setCnpj(rs.getString("cnpj"));
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setTelefone(rs.getString("telefone"));
            
            //move o objeto para a colecao
            lista.add(fornecedor);
        }
                
        Banco.desconectar();
        
        return lista;   
    }
}
