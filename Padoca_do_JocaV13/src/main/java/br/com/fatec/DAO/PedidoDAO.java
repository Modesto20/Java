package br.com.fatec.DAO;

import br.com.fatec.model.Pedido;
import br.com.fatec.persistencia.Banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class PedidoDAO implements DAO<Pedido> {
    private java.sql.PreparedStatement pst;
    private java.sql.ResultSet rs;
    
    private Pedido pedido;
    
    @Override
    public boolean insere(Pedido obj) throws SQLException {
        String sql = "INSERT INTO Pedido (id_Pedido, qtd_Pedido, valor_Total, nome_Cliente, nome_Produto, cpf, id_Produto) " +
                     " VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Pedido com o comando INSERT
        pst.setInt(1, obj.getId_Pedido());
        pst.setInt(2, obj.getQtd_Pedido());
        pst.setFloat(3, obj.getValor_Total());
        pst.setString(4, obj.getNome_Cliente());
        pst.setString(5, obj.getNome_Produto());
        pst.setString(6, obj.getCpf());
        pst.setInt(7, obj.getId_Produto());
        
        int res = pst.executeUpdate(); //esse metodo serve para INSERT, DELETE e UPDATE
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public boolean remove(Pedido obj) throws SQLException {
        String sql = "DELETE FROM Pedido WHERE id_Pedido = ?";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Pedido com o comando DELETE
        pst.setInt(1, obj.getId_Pedido());
        
        int res = pst.executeUpdate();
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public boolean altera(Pedido obj) throws SQLException {
        String sql = "UPDATE Pedido SET qtd_Pedido = ? , "
                   + "valor_Total = ? , "
                   + "nome_Cliente = ? , "
                   + "nome_Produto = ? , "
                   + "cpf = ? , "
                   + "id_Produto = ? "
                   + "WHERE id_Pedido = ?";
        
        Banco.conectar();
       
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //associar os dados do objeto Pedido com o comando UPDATE
        pst.setInt(7, obj.getId_Pedido());
        pst.setInt(1, obj.getQtd_Pedido());
        pst.setFloat(2, obj.getValor_Total());
        pst.setString(3, obj.getNome_Cliente());
        pst.setString(4, obj.getNome_Produto());
        pst.setString(5, obj.getCpf());
        pst.setInt(6, obj.getId_Produto());
        
        int res = pst.executeUpdate(); 
        
        Banco.desconectar();
        
        return res != 0;
    }
    
    @Override
    public Pedido buscaID(Pedido obj) throws SQLException {
        String sql = "SELECT * FROM Pedido "
                   + "WHERE id_Pedido = ?";
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        pst.setInt(1, obj.getId_Pedido());
        
        rs = pst.executeQuery(); //esse metodo serve para SELECT
        
        //verificar se trouxe algum registro
        //rs.next() faz a leitura do proximo registro, se existir devolve true
        //se nao devolve false
        if(rs.next()) {
            pedido = new Pedido();
            pedido.setId_Pedido(rs.getInt("id_Pedido"));
            pedido.setQtd_Pedido(rs.getInt("qtd_Pedido"));
            pedido.setValor_Total(rs.getFloat("valor_Total"));
            pedido.setNome_Cliente(rs.getString("nome_Cliente"));
            pedido.setNome_Produto(rs.getString("nome_Produto"));
            pedido.setCpf(rs.getString("cpf"));
            pedido.setId_Produto(rs.getInt("id_Produto"));
        }
        else {
            //nao encontrou o registro solicitado
            pedido = null;
        }
                
        Banco.desconectar();
        
        //devolve o objeto pedido
        return pedido;
    }
    
    @Override
    public Collection<Pedido> lista(String criterio) throws SQLException {
        //cria uma lista para armazenar os dados vindos do banco
        ArrayList<Pedido> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Pedido ";

        //precisa fazer filtro para listagem
        if(criterio != null && criterio.length() > 0) {
            sql += " WHERE " + criterio;
        }
        
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        while(rs.next()) {
            //criar o objeto
            pedido = new Pedido();
            
            pedido.setId_Pedido(rs.getInt("id_Pedido"));
            pedido.setQtd_Pedido(rs.getInt("qtd_Pedido"));
            pedido.setValor_Total(rs.getFloat("valor_Total"));
            pedido.setNome_Cliente(rs.getString("nome_Cliente"));
            pedido.setNome_Produto(rs.getString("nome_Produto"));
            pedido.setCpf(rs.getString("cpf"));
            pedido.setId_Produto(rs.getInt("id_Produto"));
            
            //move o objeto para a colecao
            lista.add(pedido);
        }
                
        Banco.desconectar();
        
        return lista;   
    }
}
