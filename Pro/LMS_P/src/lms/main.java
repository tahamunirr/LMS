package lms;

import java.sql.Connection;

public class main {

		public int yolo=0;
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			database data = new database();
			Connection connect = data.getConnection();
			
//			try         
//			{   
//				String query = "INSERT INTO student values (?,?,?);";                  
//				PreparedStatement stm = connect.prepareStatement(query);         
//				stm.setInt(1,18);         
//				stm.setInt(2,1122);         
//				stm.setInt(3,1);                  
//				stm.execute();         }         
//				catch(SQLException e)
//				{            
//					e.printStackTrace();         
//				}
			
		
			gui hm = new gui();
			hm.frame.setVisible(true);
		
		}

	}


