package br.com.fatec.DAO;

import br.com.fatec.model.Produto;
import br.com.fatec.persistencia.Banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ProdutoDAO implements DAO<Produto> {
    private java.sql.PreparedStatement pst;
    private java.sql.ResultSet rs;
    
    private Produto produto;
    
    @Override
    public boolean insere(Produto obj) throws SQLException {
        String sql = "INSERT INTO Produto (id_Produto, preco, descricao) " +
                     " VALUES (?, ?, ?)";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Produto com o comando INSERT
        pst.setInt(1, obj.getId_Produto());
        pst.setFloat(2, obj.getPreco());
        pst.setString(3, obj.getDescricao());
        
        int res = pst.executeUpdate(); //esse metodo serve para INSERT, DELETE e UPDATE
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public boolean remove(Produto obj) throws SQLException {
        String sql = "DELETE FROM Produto WHERE id_Produto = ?";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Produto com o comando DELETE
        pst.setInt(1, obj.getId_Produto());
        
        int res = pst.executeUpdate();
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public boolean altera(Produto obj) throws SQLException {
        String sql = "UPDATE Produto SET preco = ? , "
                   + "descricao = ? "
                   + "WHERE id_Produto = ?";
        
        Banco.conectar();
       
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Produto com o comando UPDATE
        pst.setInt(3, obj.getId_Produto());
        pst.setFloat(1, obj.getPreco());
        pst.setString(2, obj.getDescricao());
        
        int res = pst.executeUpdate(); 
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public Produto buscaID(Produto obj) throws SQLException {
        String sql = "SELECT * FROM Produto "
                   + "WHERE id_Produto = ?";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        pst.setInt(1, obj.getId_Produto());
        
        rs = pst.executeQuery(); //esse metodo serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do proximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            produto = new Produto();
            produto.setId_Produto(rs.getInt("id_Produto"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setDescricao(rs.getString("descricao"));
        }
        else {
            //nao encontrou o registro solicitado
            produto = null;
        }
                
        Banco.desconectar();
        
        //devolve o objeto produto
        return produto;
    }
    
    @Override
    public Collection<Produto> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Produto> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Produto ";

        //precisa fazer filtro para listagem
        if(criterio != null && criterio.length() > 0) {
            sql += " WHERE " + criterio;
        }
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        while(rs.next()) {
            //criar o objeto
            produto = new Produto();
            
            produto.setId_Produto(rs.getInt("id_Produto"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setDescricao(rs.getString("descricao"));
            
            //move o objeto para a colecao
            lista.add(produto);
        }
                
        Banco.desconectar();
        
        return lista;   
    }
}
