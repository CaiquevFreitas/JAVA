package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Anime;

public class Dados {
    
    public void salvar(Anime a){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO lista_anime (nome,genero,nota,classificacao)VALUES(?,?,?,?)");
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getGenero());
            stmt.setDouble(3, a.getNota());
            stmt.setString(4, a.getClassficacao());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Anime> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Anime> animes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("Select * From lista_anime");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Anime a = new Anime();
                 
                a.setNome(rs.getString("NOME"));
                a.setGenero(rs.getString("GENERO"));
                a.setNota(rs.getDouble("NOTA"));
                a.setClassficacao(rs.getString("CLASSIFICACAO"));
                animes.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Dados.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return animes;
    }
    
    public List<Anime> searchNome(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Anime> animes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("Select * From lista_anime Where nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){ 
                Anime a = new Anime();
                
                a.setNome(rs.getString("NOME"));
                a.setGenero(rs.getString("GENERO"));
                a.setNota(rs.getDouble("NOTA"));
                a.setClassficacao(rs.getString("CLASSIFICACAO"));
                animes.add(a);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Anime não encontrado!");
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return animes;
    }
    
    public List<Anime> searchGenero(String genero){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Anime> animes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("Select * From lista_anime Where genero LIKE ?");
            stmt.setString(1, "%"+genero+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Anime a = new Anime(); 
                
                a.setNome(rs.getString("NOME"));
                a.setGenero(rs.getString("GENERO"));
                a.setNota(rs.getDouble("NOTA"));
                a.setClassficacao(rs.getString("CLASSIFICACAO"));
                animes.add(a);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gênero não encontrado!");
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return animes;
    }
    
    public void editar(Anime a){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("Update lista_anime Set nome = ?, genero = ?, nota = ?, classificacao = ?"
                    + "Where nome = ?");
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getGenero());
            stmt.setDouble(3, a.getNota());
            stmt.setString(4, a.getClassficacao());
            stmt.setString(5, a.getNome());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao editar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Anime> seachEdit(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Anime> edit = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("Select * From lista_anime Where nome Like ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Anime a = new Anime(); 
                
                a.setNome(rs.getString("NOME"));
                a.setGenero(rs.getString("GENERO"));
                a.setNota(rs.getDouble("NOTA"));
                edit.add(a);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Anime não encontrado!");
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return edit;
    }
   
}
