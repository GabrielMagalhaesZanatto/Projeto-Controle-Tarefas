/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import jdbc.ConnectionFactory;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import models.Tarefa;

/**
 *
 * @author gabri
 */
public class TarefaDAO {
    private Connection con;
    
    public TarefaDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarTarefa(Tarefa obj){
        try {
            String sql = "insert into tb_tarefas (titulo,descricao,datas,estatus)"
                    + "values (?,?,?,?)"; 
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, obj.getTitulo());
            stmt.setString(2, obj.getDescricao());
            stmt.setString(3, obj.getDatas());
            stmt.setString(4, obj.getEstatus());
            
            stmt.execute();
            stmt.close();
                  
            JOptionPane.showMessageDialog(null, "Tarefa Cadastrada com Sucesso!!!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO: " + erro);
        }
    }
    
    public List<Tarefa> listarTarefas(){
        try {
            String sql = "select * from tb_tarefas";
            
            List<Tarefa> lista = new ArrayList<>();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Tarefa obj = new Tarefa();
                
                obj.setId(rs.getInt("Id"));
                obj.setTitulo(rs.getString("Titulo"));
                obj.setDescricao(rs.getString("Descricao"));
                obj.setDatas(rs.getString("Datas"));
                obj.setEstatus(rs.getString("Estatus"));
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO: " + erro);
            return null;
        }
    }
    
    public void alterarTarefa(Tarefa obj){
        
        try {
            String sql = "update tb_tarefas set titulo = ?, descricao = ?, datas = ?, estatus = ? where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getTitulo());
            stmt.setString(2, obj.getDescricao());
            stmt.setString(3, obj.getDatas());
            stmt.setString(4, obj.getEstatus());
            
            stmt.setInt(5, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Tarefa alterada com sucesso!!!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO: " + erro);
        }
    }
    
    public void excluirTarefa(int id){
        try {
            String sql = "delete from tb_tarefas where id=?;";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        
        JOptionPane.showMessageDialog(null, "Tarefa excluida com sucesso!!!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO: " + erro);
        }
   }
    
    public List<Tarefa> buscarTarefaPeloTitulo(String titulo){
        try {
            String sql = "select * from tb_tarefas where titulo like ?";
            
            List<Tarefa> lista = new ArrayList<>();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, titulo);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Tarefa obj = new Tarefa();
                
                obj.setId(rs.getInt("Id"));
                obj.setTitulo(rs.getString("Titulo"));
                obj.setDescricao(rs.getString("Descricao"));
                obj.setDatas(rs.getString("Datas"));
                obj.setEstatus(rs.getString("Estatus"));
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "ERRO: " + erro);
            return null;
            
        }
    }
}

 