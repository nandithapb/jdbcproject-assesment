package com.assesment.dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.assesment.bo.AddplayerBO;

public class AddplayerDAO {
	public static void Add(Connection connection, AddplayerBO abo) throws SQLException {
		Statement st= connection.createStatement();
		String query="insert into players values('"+abo.getPlayername()+"','"+abo.getCountryname()+"','"+abo.getSkill()+"','"+abo.getTeamname()+"')";
		int result=st.executeUpdate(query);
		if(result==1) {
			System.out.println("Data inserted Successfully");
		}
		else {
			System.out.println("Problem");
		}
}
}