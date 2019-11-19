package com.assesment.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Listplayer {
	public static void Display(Connection connection) throws SQLException{
		Statement st= connection.createStatement();
		ResultSet rs = st.executeQuery("select playername,country,skill,teamname from players ");
		System.out.println("Playername\t country\t skill\t Teamname");
		while(rs.next())
		{
		System.out.println(rs.getString("playername")+"\t"+rs.getString("country")+"\t"+rs.getString("skill")+"\t"+rs.getString("teamname"));
		}
		
	}
}
