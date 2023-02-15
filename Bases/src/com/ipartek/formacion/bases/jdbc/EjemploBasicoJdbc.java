package com.ipartek.formacion.bases.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EjemploBasicoJdbc {
	public static void main(String[] args) {
		final String URL = "jdbc:sqlite:sql/almacen.db";
		final String USER = "";
		final String PASSWORD = "";

		final String SQL_SELECT = "SELECT * FROM productos";
		final String SQL_SELECT_ID = "SELECT * FROM productos WHERE id=?";
		final String SQL_INSERT = "INSERT INTO productos (nombre, precio, stock, fecha_caducidad) VALUES (?,?,?,?)";
		final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, stock=?, fecha_caducidad=? WHERE id=?";
		final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

		try (Scanner sc = new Scanner(System.in); Connection con = DriverManager.getConnection(URL, USER, PASSWORD);) {
			try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(SQL_SELECT)) {

				while (rs.next()) {
					System.out.printf("%s, %s, %s, %s, %s\n", rs.getInt("id"), rs.getString("nombre"),
							rs.getBigDecimal("precio"), rs.getInt("stock"), rs.getString("fecha_caducidad"));
				}
			} catch (SQLException e) {
				System.err.println("No se ha podido consultar los registros");
				e.printStackTrace();
			}

			try (PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID)) {
				int id = 1;

				pst.setInt(1, id);

				try (ResultSet rs = pst.executeQuery()) {

					if (rs.next()) {
						System.out.printf("%s, %s, %s, %s, %s\n", rs.getInt("id"), rs.getString("nombre"),
								rs.getBigDecimal("precio"), rs.getInt("stock"), rs.getString("fecha_caducidad"));
					}

				}
			} catch (SQLException e) {
				System.err.println("No se ha podido leer el registro");
				e.printStackTrace();
			}

			try (PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {
				pst.setString(1, "Nuevo");
				pst.setBigDecimal(2, new BigDecimal("1234.56"));
				pst.setInt(3, 5);
				pst.setString(4, "2000-01-01");

				int modificados = pst.executeUpdate();

				System.out.println(modificados);

				sc.nextLine();
			} catch (SQLException e) {
				System.err.println("No se ha podido insertar");
				e.printStackTrace();
			}

			try (PreparedStatement pst = con.prepareStatement(SQL_UPDATE)) {

				pst.setString(1, "Modificado");
				pst.setBigDecimal(2, new BigDecimal("234.56"));
				pst.setInt(3, 10);
				pst.setString(4, "2005-05-10");
				pst.setInt(5, 3);

				int modificados = pst.executeUpdate();

				System.out.println(modificados);

				sc.nextLine();
			} catch (SQLException e) {
				System.err.println("No se ha podido modificar");
				e.printStackTrace();
			}

			try (PreparedStatement pst = con.prepareStatement(SQL_DELETE)) {

				pst.setInt(1, 3);

				int modificados = pst.executeUpdate();

				System.out.println(modificados);
			} catch (SQLException e) {
				System.err.println("No se ha podido borrar");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.err.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}
}
