package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDAOImpl implements CaveDAO {

	@Override
	public void createCave(Cave c) {
		// Opening a new connection
		try(Connection conn = ConnectionUtil.getConnection()) {
			//Storing class fields as future arguments
			String n = c.getName();
			int m = c.getMaxBears();
			
			//Declare sql statement + arguments
			String sql = "INSERT INTO CAVE(CAVE_NAME, MAX_BEARS) VALUES('" + n + "', " + m + ")";
			
			//Create the statement, as part of the connection
			Statement stmt = conn.createStatement();
			
			//Execute the statement, return number of rows affected
			int nRowsAffected = stmt.executeUpdate(sql);
			
			System.out.println(nRowsAffected + " row created");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void readCave(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM CAVE WHERE CAVE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  id);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String caveid = rs.getString("CAVE_ID");
				String cavename = rs.getString("CAVE_NAME");
				
				System.out.println("CaveID: " + caveid);
				System.out.println("CaveName: " + cavename);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {try {pstmt.close();} catch(SQLException e) {e.printStackTrace();}}
			if (rs != null) {try {rs.close();} catch(SQLException e) {e.printStackTrace();}}
		}		
			
	}
	
	@Override
	public List<Cave> readAllCaves() {
		PreparedStatement pstmt = null;
		List<Cave> caves = new ArrayList<>();
		try {
			Connection conn = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM CAVE";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("CAVE_ID");
				String name = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				
				Cave c = new Cave(id, name, maxBears);
				caves.add(c);
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null) {
				try {pstmt.close();} 
				catch(SQLException e) {e.printStackTrace();}
			}
		}
		return caves;
	}

	@Override
	public void updateCave(Cave c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCave(int id) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void feedBear(int bid, int amt) {
		//Callable Statement, extends PreparedStatement
		CallableStatement cs = null;
		try (Connection conn = ConnectionUtil.getConnectionProp()) {
			//CallableStatement: {CALL PROCEDURE_NAME(?)}
			String sql = "{CALL SP_FEED_BEAR(?, ?)}";
			cs = conn.prepareCall(sql);
			
			//Set the arguments
			cs.setInt(1, bid);
			cs.setInt(2, amt);
			
			//Execute (returns boolean)
			Boolean result = cs.execute();
			if (result)
				System.out.println("Fed Bear");
			else
				System.out.println("Failed, and was eaten");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}




