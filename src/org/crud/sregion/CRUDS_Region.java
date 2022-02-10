package org.crud.sregion;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//CRUD: CREATE, READ, UPDATE, DELETE.

public class CRUDS_Region {
	
	static Connection connection;
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	public static void connectionOracleDatabase()throws IOException, SQLException{
		
		try {
			
			Class.forName(driver).newInstance();
			System.out.println("Cargo Driver Correctamente");
			
		} catch (Exception e) {
			
			System.out.println("Exception:" + e.getMessage());
		}
		
		try {
			
			connection = DriverManager.getConnection(URL, "System", "12121212Qw.");
			System.out.println("Conexión Exitosa a Oracle Data Base");
			
		} catch (Exception e) {
			
			System.out.println("Exception:" + e.getMessage());
		}
	}
	
/*	public static void agregarS_Region(int id, String name) throws IOException, SQLException {
		
		try {
			
			connectionOracleDatabase();
			
			//CONSULTA
			String sql = "INSERT INTO S_REGION (ID, NAME) VALUES (?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.executeQuery();
			ps.close();
			connection.close();
			
			System.out.println("INSERTO:" + id + "," + name);
			
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
		
	}*/
	
     /*public static void actualizarS_Region(int id, String name) throws IOException, SQLException {
		
		try {
			
			connectionOracleDatabase();
			
			//ACTUALIZAR
			String sql = "UPDATE S_REGION SET ID = ? WHERE NAME = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.executeQuery();
			ps.close();
			connection.close();
			
			System.out.println("ACTUALIZO:" + id + "," + name);
			
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
		
	}*/
	
    /*public static void eliminarS_Region(int id) throws IOException, SQLException {
	
		try {
			
			connectionOracleDatabase();
			
			//CONSULTA INDIVIDUAL
			String sql = "DELETE FROM S_REGION WHERE ID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeQuery();
			ps.close();
			connection.close();
			
			System.out.println("ELIMINO:" + id);
			
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
		
	}*/
	
    /*public static void consultaIndividualS_Region(int id) throws IOException, SQLException {
    	
		try {
			
			connectionOracleDatabase();
			
			//ELIMINAR
			String sql = "SELECT * FROM S_REGION WHERE ID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rSet = ps.executeQuery();
			if (rSet.next()) {
				
				System.out.println(rSet.getInt("id") + "," + rSet.getString("name"));
				
			}
			
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
    }*/
    
    /*public static void consultaGeneralS_Region() throws IOException, SQLException {
    	
		try {
			
			connectionOracleDatabase();
			
			//CONSULTA GENERAL
			String sql = "SELECT * FROM S_REGION";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rSet = ps.executeQuery();
			if (rSet.next()) {
				
				System.out.println(rSet.getInt("id") + "," + rSet.getString("name"));
				
			}
			
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
    }*/
    
    public static void invocarProcedimientoAlmacenado(int id, String name) throws IOException, SQLException {
    	
		try {
			
			connectionOracleDatabase();
			
			//INVOCAR PROCEDIMIENTO ALMACENADO
			CallableStatement cs = connection.prepareCall("CALL proc (?,?)");
			cs.setInt(1,  id);
			cs.setString(2, name);
			cs.execute();
			
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
    }
	
	public static void main(String[] args) throws IOException, SQLException {
		
		//agregarS_Region(15, "COAHUILA");
		//actualizarS_Region(12, "COAHUILA");
		//eliminarS_Region(12);
		//consultaIndividualS_Region(2);
		//consultaGeneralS_Region();
		invocarProcedimientoAlmacenado(12, "BC");
		
	}
}
	