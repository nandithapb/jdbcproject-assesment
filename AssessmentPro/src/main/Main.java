package main;
import java.util.*;
import java.sql.SQLException;
import com.assesment.bo.AddplayerBO;
import com.assesment.bo.SkillBO;
import com.assesment.dao.AddplayerDAO;
import com.assesment.dao.Listplayer;
import com.assesment.dao.SkillDAO;
import com.assesment.util.ConnectionManager;
public class Main {
	public static void main(String[] args) throws SQLException, Exception {
		Scanner sc=new Scanner(System.in);
		AddplayerBO abo=new AddplayerBO();
		ConnectionManager conn=new ConnectionManager();
		SkillBO sbo=new SkillBO();
		int option;
		do {
			System.out.println("Menu");
			System.out.println("1.List of all players\n2.Add new players\n3.Search player");
			option=sc.nextInt();
			switch (option)
				{
					case 1:
						Listplayer.Display(conn.getConnection());
						break;
					case 2:
						String playername;
						String countryname;
						String skill;
						String teamname;
						System.out.println("Add player details\n");
						System.out.println("Enter player name:");
						playername=sc.next();
						abo.setPlayername(playername);
						System.out.println("Enter Country name:");
						countryname=sc.next();
						abo.setCountryname(countryname);
						System.out.println("Enter skill:");
						skill=sc.next();
						abo.setSkill(skill);
						System.out.println("Enter team name:");
						teamname=sc.next();
						abo.setTeamname(teamname);
						AddplayerDAO.Add(conn.getConnection(), abo);
						break;
					case 3:
						System.out.println("Search player");
						System.out.println("Enter skill:");
						String skillname;
						skillname=sc.next();
						sbo.setSkillname(skillname);
						SkillDAO.Search(conn.getConnection(), sbo);
				}
		}while(true);	
	}
}
