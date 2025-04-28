package net.pruebatecnica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.pruebatecnica.conexion.Conexion;
import net.pruebatecnica.model.Proveedor;

public class ProveedorDAO {

	
	
	
	
	private static final String SELECT_PROVEEDORES_BY_ID_CLIENTE = "select * from proveedores.proveedores where id_cliente= ?";
	private static final String SELECT_ALL_PROVEEDORES = "select * from proveedores.proveedores";
	
	
	
	public List<Proveedor> selectAllProveedores() {
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		
		try (Connection connection = obtenerConexion();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROVEEDORES);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int idProveedor = rs.getInt("id_proveedor");
				String nombre = rs.getString("nombre");
				String fechaAlta = rs.getDate("fecha_alta").toString();
				int idCliente = rs.getInt("id_cliente");
				proveedores.add(new Proveedor(idProveedor, nombre, fechaAlta, idCliente));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return proveedores;
	}
	
	public List<Proveedor> selectProveedoresByIdCliente(int id) {
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		
		try (Connection connection = obtenerConexion();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROVEEDORES_BY_ID_CLIENTE);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			

			while (rs.next()) {
				int idProveedor = rs.getInt("id_proveedor");
				String nombre = rs.getString("nombre");
				String fechaAlta = rs.getDate("fecha_alta").toString();
				int idCliente = rs.getInt("id_cliente");
				proveedores.add(new Proveedor(idProveedor, nombre, fechaAlta, idCliente));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return proveedores;
	}
	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}
}
