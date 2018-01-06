/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.List;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.*;
import oracleDB.*;
import view.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.*;
import javax.swing.JComboBox;
/**
 *
 * @author Cristian
 */
public class Registro {
        public boolean Grabar(Categoria categoria) {
        try {
            
            Connection conexion =Conexion.conect();
            String query = "INSERT INTO CATEGORIA(ID,DESCRIPCION) values(?,?)";
            PreparedStatement ingresar = conexion.prepareStatement(query);
            ingresar.setInt(1, categoria.getId());
            ingresar.setString(2, categoria.getDescripcion());
            
            ingresar.execute();
            ingresar.close();
            conexion.close(); 
            return true;
            
                       
        }catch(SQLException s){
            System.out.println("Error SQL al agregar Categoría"+s.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Error al agregar Categoría"+e.getMessage());
            return false;
        }

    }
        public boolean GrabarP(Pelicula pelicula) {
        try {
            
            Connection conexion =Conexion.conect();
            String query = "INSERT INTO PELICULA(CODIGO,PRECIO,ID,FORMATO4K,NOMBRE) values(?,?,?,?,?)";
            PreparedStatement ingresar = conexion.prepareStatement(query);
            ingresar.setInt(1, pelicula.getCodigo());
            ingresar.setInt(2, pelicula.getPrecio());
            ingresar.setInt(3,pelicula.getId());
            ingresar.setString(4, pelicula.getFormato4k());
            ingresar.setString(5, pelicula.getNombre());
            
            ingresar.execute();
            ingresar.close();
            conexion.close(); 
            return true;
            
                       
        }catch(SQLException s){
            System.out.println("Error SQL al agregarP Pelicula"+s.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Error al agregarP Pelicula"+e.getMessage());
            return false;
        }

    }
        
        public  boolean Check(int id){
        boolean codigoExiste=false;
        try{
            Connection conexion=Conexion.conect();
            String query="Select * from CATEGORIA";
            PreparedStatement verificar=conexion.prepareStatement(query);
            ResultSet r1=verificar.executeQuery();int codigo;
            while(r1.next()){
                codigo=r1.getInt("ID");
                if(codigo==id){
                    System.out.println("Código Existe");
                    codigoExiste=true;
                    
                }
            }
        }
        catch (SQLException e) 
     {
        System.out.println("SQL Exception: "+ e.toString());
     } 
        return codigoExiste;
    }
        
        public  boolean CheckP(int cod){
        boolean codigoExiste=false;
        try{
            Connection conexion=Conexion.conect();
            String query="Select * from PELICULA";
            PreparedStatement verificar=conexion.prepareStatement(query);
            ResultSet r1=verificar.executeQuery();int codigo;
            while(r1.next()){
                codigo=r1.getInt("CODIGO");
                if(codigo==cod){
                    System.out.println("Código Existe");
                    codigoExiste=true;
                    
                }
            }
        }
        catch (SQLException e) 
     {
        System.out.println("SQL Exception: "+ e.toString());
     } 
        return codigoExiste;
    }
        
        public  boolean CheckPP(int cod){
        boolean codigoExiste=false;
        try{
            Connection conexion=Conexion.conect();
            String query="Select * from PELICULA WHERE PRECIO>2000";
            PreparedStatement verificar=conexion.prepareStatement(query);
            ResultSet r1=verificar.executeQuery();int codigo;
            while(r1.next()){
                codigo=r1.getInt("CODIGO");
                if(codigo==cod){
                    System.out.println("Código Existe");
                    codigoExiste=true;
                    
                }
            }
        }
        catch (SQLException e) 
     {
        System.out.println("SQL Exception: "+ e.toString());
     } 
        return codigoExiste;
    }
        
        
        public Categoria VerificarC(int id){
        Categoria categoria=new Categoria();
        try{
            Connection conexion=Conexion.conect();
            String query="SELECT * FROM CATEGORIA where ID=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, id);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                categoria.setId(rs.getInt("ID"));
                categoria.setDescripcion(rs.getString("DESCRIPCION"));
                }
            conexion.close();
        }catch(SQLException s){
            System.out.println("Error SQL al verificar Categoría"+s.getMessage());
           
        }catch(Exception e){
            System.out.println("Error al verificar Categoría"+e.getMessage());
        }
        return categoria;
    }
         public JTable BuscarP(JTable table,int Codigo){
            Connection conexion=Conexion.conect();

        DefaultTableModel peliculas=new DefaultTableModel();
        
        peliculas.addColumn("ID");
        peliculas.addColumn("Descripción");
        peliculas.addColumn("Código");
        peliculas.addColumn("Precio");
        peliculas.addColumn("Formato4K");
        peliculas.addColumn("Nombre");
       
        table.setModel(peliculas);
        String query="SELECT * FROM  CATEGORIA JOIN PELICULA USING(ID) WHERE CODIGO=?";
        Object[]datos=new Object[9];
        try{
            PreparedStatement st=conexion.prepareStatement(query);
            st.setInt(1, Codigo);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                datos[0]=rs.getObject("ID");
                datos[1]=rs.getObject("DESCRIPCION");
                datos[2]=rs.getObject("CODIGO");
                datos[3]=rs.getObject("PRECIO");
                datos[4]=rs.getObject("FORMATO4K");
                datos[5]=rs.getObject("NOMBRE");
                
                peliculas.addRow(datos);
            }
            table.setModel(peliculas);
        }
        catch (Exception e) {
            System.out.println("Error la buscar por codigo " + e.getMessage());
        }
     return table;           
    }
         
         
       public JTable BuscarC(JTable table,int Codigo){
            Connection conexion=Conexion.conect();

        DefaultTableModel peliculas=new DefaultTableModel();
        
        peliculas.addColumn("ID");
        peliculas.addColumn("Descripción");
        peliculas.addColumn("Código");
        peliculas.addColumn("Precio");
        peliculas.addColumn("Formato4K");
        peliculas.addColumn("Nombre");
       
        table.setModel(peliculas);
        String query="SELECT * FROM  CATEGORIA JOIN PELICULA USING(ID) WHERE ID=?";
        Object[]datos=new Object[9];
        try{
            PreparedStatement st=conexion.prepareStatement(query);
            st.setInt(1, Codigo);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                datos[0]=rs.getObject("ID");
                datos[1]=rs.getObject("DESCRIPCION");
                datos[2]=rs.getObject("CODIGO");
                datos[3]=rs.getObject("PRECIO");
                datos[4]=rs.getObject("FORMATO4K");
                datos[5]=rs.getObject("NOMBRE");
                
                peliculas.addRow(datos);
            }
            table.setModel(peliculas);
        }
        catch (Exception e) {
            System.out.println("Error la buscar por codigo " + e.getMessage());
        }
     return table;           
    }
       public JTable BuscarCP(JTable table,String Codigo){
            Connection conexion=Conexion.conect();

        DefaultTableModel peliculas=new DefaultTableModel();
        
        peliculas.addColumn("ID");
        peliculas.addColumn("Descripción");
        peliculas.addColumn("Código");
        peliculas.addColumn("Precio");
        peliculas.addColumn("Formato4K");
        peliculas.addColumn("Nombre");
       
        table.setModel(peliculas);
        String query="SELECT * FROM  CATEGORIA JOIN PELICULA USING(ID) WHERE DESCRIPCION=?";
        Object[]datos=new Object[9];
        try{
            PreparedStatement st=conexion.prepareStatement(query);
            st.setString(1, Codigo);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                datos[0]=rs.getObject("ID");
                datos[1]=rs.getObject("DESCRIPCION");
                datos[2]=rs.getObject("CODIGO");
                datos[3]=rs.getObject("PRECIO");
                datos[4]=rs.getObject("FORMATO4K");
                datos[5]=rs.getObject("NOMBRE");
                
                peliculas.addRow(datos);
            }
            table.setModel(peliculas);
        }
        catch (Exception e) {
            System.out.println("Error la buscar por codigo " + e.getMessage());
        }
     return table;           
    }
       public boolean EliminarP(int Codigo){
        try{
            Connection conexion=Conexion.conect();
            String query="DELETE FROM PELICULA WHERE CODIGO=?";
            PreparedStatement eliminar=conexion.prepareStatement(query);
            eliminar.setInt(1,Codigo);
            if (eliminar.executeUpdate() > 0) {
                return true;
            }
             conexion.close();
        }
        catch(SQLException s){
            System.out.println("Error SQL al eliminar Pelicula"+s.getMessage());
           
        }catch(Exception e){
            System.out.println("Error al eliminar Película"+e.getMessage());
        }
        return false;
    }
       public boolean EliminarPP(int Codigo){
        try{
            Connection conexion=Conexion.conect();
            String query="DELETE FROM PELICULA WHERE PRECIO> 2000 AND CODIGO=?";
            PreparedStatement eliminar=conexion.prepareStatement(query);
            eliminar.setInt(1,Codigo);
            if (eliminar.executeUpdate() > 0) {
                return true;
            }
             conexion.close();
        }
        catch(SQLException s){
            System.out.println("Error SQL al eliminar Pelicula"+s.getMessage());
           
        }catch(Exception e){
            System.out.println("Error al eliminar Película"+e.getMessage());
        }
        return false;
    }
       public boolean EliminarC(int id){
        try{
            Connection conexion=Conexion.conect();
            String query="DELETE FROM CATEGORIA WHERE ID=?";
            PreparedStatement eliminar=conexion.prepareStatement(query);
            eliminar.setInt(1,id);
            if (eliminar.executeUpdate() > 0) {
                return true;
            }
             conexion.close();
        }
        catch(SQLException s){
            System.out.println("Error SQL al eliminar Categoría"+s.getMessage());
           
        }catch(Exception e){
            System.out.println("Error al eliminar Categoría"+e.getMessage());
        }
        return false;
    }
       
       public JTable Mostrar(JTable table){
            Connection conexion=Conexion.conect();

        DefaultTableModel peliculas=new DefaultTableModel();
        
        peliculas.addColumn("ID");
        peliculas.addColumn("Descripción");
        peliculas.addColumn("Código");
        peliculas.addColumn("Precio");
        peliculas.addColumn("Formato 4K");
        peliculas.addColumn("Nombre");
        
        table.setModel(peliculas);
        String query="SELECT * FROM CATEGORIA JOIN PELICULA USING(ID)";
        Object[]datos=new Object[9];
        try{
            Statement st=conexion.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                datos[0]=rs.getObject("ID");
                datos[1]=rs.getObject("DESCRIPCION");
                datos[2]=rs.getObject("CODIGO");
                datos[3]=rs.getObject("PRECIO");
                datos[4]=rs.getObject("FORMATO4K");
                datos[5]=rs.getObject("NOMBRE");
                
                peliculas.addRow(datos);
            }
            table.setModel(peliculas);
        }
        catch (SQLException ex) {
            Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
     return table;           
    }
       public JTable MostrarPP(JTable table){
            Connection conexion=Conexion.conect();

        DefaultTableModel peliculas=new DefaultTableModel();
        
        peliculas.addColumn("ID");
        peliculas.addColumn("Descripción");
        peliculas.addColumn("Código");
        peliculas.addColumn("Precio");
        peliculas.addColumn("Formato 4K");
        peliculas.addColumn("Nombre");
        
        table.setModel(peliculas);
        String query="SELECT * FROM CATEGORIA JOIN PELICULA USING(ID) WHERE PRECIO>2000";
        Object[]datos=new Object[9];
        try{
            Statement st=conexion.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                datos[0]=rs.getObject("ID");
                datos[1]=rs.getObject("DESCRIPCION");
                datos[2]=rs.getObject("CODIGO");
                datos[3]=rs.getObject("PRECIO");
                datos[4]=rs.getObject("FORMATO4K");
                datos[5]=rs.getObject("NOMBRE");
                
                peliculas.addRow(datos);
            }
            table.setModel(peliculas);
        }
        catch (SQLException ex) {
            Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
     return table;           
    }
       
       public JTable MostrarC(JTable table){
            Connection conexion=Conexion.conect();

        DefaultTableModel peliculas=new DefaultTableModel();
        
        peliculas.addColumn("ID");
        peliculas.addColumn("Descripción");
        
        
        table.setModel(peliculas);
        String query="SELECT * FROM CATEGORIA ";
        Object[]datos=new Object[9];
        try{
            Statement st=conexion.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                datos[0]=rs.getObject("ID");
                datos[1]=rs.getObject("DESCRIPCION");
                
                
                peliculas.addRow(datos);
            }
            table.setModel(peliculas);
        }
        catch (SQLException ex) {
            Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
     return table;           
    }
       public Pelicula VerificarP(int Codigo){
        Pelicula pelicula=new Pelicula();
        try{
            Connection conexion=Conexion.conect();
            String query="SELECT * FROM CATEGORIA JOIN PELICULA USING(ID) WHERE CODIGO=?";
            PreparedStatement buscar=conexion.prepareStatement(query);
            buscar.setInt(1, Codigo);
            ResultSet rs = buscar.executeQuery();
            while(rs.next()){
                pelicula.setId(rs.getInt("ID"));
                pelicula.setDescripcion(rs.getString("DESCRIPCION"));
                pelicula.setCodigo(rs.getInt("CODIGO"));
                pelicula.setPrecio(rs.getInt("PRECIO"));
                pelicula.setFormato4k(rs.getString("FORMATO4K"));
                pelicula.setNombre(rs.getString("NOMBRE"));
                
                
                }
            conexion.close();
        }catch(SQLException s){
            System.out.println("Error SQL al eliminar Chocolate"+s.getMessage());
           
        }catch(Exception e){
            System.out.println("Error al eliminar Chocolate"+e.getMessage());
        }
        return pelicula;
    }
       
        public boolean Modificar(Pelicula pelicula){
        try{
            Connection conexion=Conexion.conect();
            String query="UPDATE PELICULA SET PRECIO=?,ID=?,FORMATO4K=?,NOMBRE=?"
                    + "WHERE Codigo=?";
            PreparedStatement modificar=conexion.prepareStatement(query);
            modificar.setInt(1, pelicula.getPrecio());
            modificar.setInt(2, pelicula.getId());
            
            
            
            modificar.setString(3, pelicula.getFormato4k());
            modificar.setString(4, pelicula.getNombre());
            modificar.setInt(5, pelicula.getCodigo());
            if(modificar.executeUpdate()>0){return true;}
            conexion.close();
        }
        catch(SQLException s){
            
            System.out.println("Error SQL al Modificar"+s.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,"No se encontró una categoría con esta ID");
            throw new IllegalArgumentException ();
            
        }catch(Exception e){
            System.out.println("Error al modifcar Pelicula"+e.getMessage());
            
        }
        return false;}
        
        public boolean AgregarPP(){
        try{
            Connection conexion=Conexion.conect();
            String query="UPDATE PELICULA SET NOMBRE=CONCAT('P',NOMBRE)";
            PreparedStatement modificar=conexion.prepareStatement(query);
            
            if(modificar.executeUpdate()>0){return true;}
            conexion.close();
        }
        catch(SQLException s){
            
            System.out.println("Error SQL al Modificar"+s.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,"No se encontró una categoría con esta ID");
            throw new IllegalArgumentException ();
            
        }catch(Exception e){
            System.out.println("Error al modifcar Pelicula"+e.getMessage());
            
        }
        return false;}
        
        public boolean RemoverPP(){
        try{
            Connection conexion=Conexion.conect();
            String query="UPDATE PELICULA SET NOMBRE=SUBSTR(NOMBRE,2)";
            PreparedStatement modificar=conexion.prepareStatement(query);
            
            if(modificar.executeUpdate()>0){return true;}
            conexion.close();
        }
        catch(SQLException s){
            
            System.out.println("Error SQL al Modificar"+s.getMessage());
            javax.swing.JOptionPane.showMessageDialog(null,"No se encontró una categoría con esta ID");
            throw new IllegalArgumentException ();
            
        }catch(Exception e){
            System.out.println("Error al modifcar Pelicula"+e.getMessage());
            
        }
        return false;}
        
        public JTable BuscarPalabra(JTable table,String palabra){
            Connection conexion=Conexion.conect();

        DefaultTableModel peliculas=new DefaultTableModel();
        
        peliculas.addColumn("ID");
        peliculas.addColumn("Descripción");
        peliculas.addColumn("Código");
        peliculas.addColumn("Precio");
        peliculas.addColumn("Formato 4K");
        peliculas.addColumn("Nombre");
        
        table.setModel(peliculas);
        String query="SELECT * FROM CATEGORIA JOIN PELICULA USING(ID) WHERE LOWER(NOMBRE) LIKE '%"+palabra+"%'";
        Object[]datos=new Object[9];
        try{
            Statement st=conexion.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                datos[0]=rs.getObject("ID");
                datos[1]=rs.getObject("DESCRIPCION");
                datos[2]=rs.getObject("CODIGO");
                datos[3]=rs.getObject("PRECIO");
                datos[4]=rs.getObject("FORMATO4K");
                datos[5]=rs.getObject("NOMBRE");
                
                peliculas.addRow(datos);
            }
            table.setModel(peliculas);
        }
        catch (SQLException ex) {
            Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
     return table;           
        }
        public JComboBox Valores(JComboBox cmb){
            Connection conexion=Conexion.conect();
            
            String query="SELECT * FROM CATEGORIA ";
        try{
            Statement st=conexion.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                
                cmb.addItem(rs.getString("DESCRIPCION"));
                
                
            }
            
        }
        catch (SQLException ex) {
            System.out.println("Cambiar Método");
            Logger.getLogger(Eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
            return cmb;}
}
