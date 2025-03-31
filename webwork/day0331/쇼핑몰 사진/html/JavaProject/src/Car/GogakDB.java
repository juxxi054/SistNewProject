package Car;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class GogakDB {

	DBConnect db = new DBConnect();

	
	public void SelectGogak(GogakInfo item) {

		String sql = "select c.num, car_name,car_made,car_color,gogak_name,gogak_hp,"
				+ "gogak_addr from car c, gogak g where c.num = g.num order by c.num";
		Connection co = db.getConnection();
		PreparedStatement pst = null;
		ResultSet re = null;
		
		try {
			pst = co.prepareStatement(sql);
			re = pst.executeQuery();
			
			item.model.setRowCount(0);
			
			while (re.next()) {
				Vector<String> data = new Vector<String>();
				
				data.add(re.getString("num"));
				data.add(re.getString("car_name"));
				data.add(re.getString("car_made"));
				data.add(re.getString("car_color"));
				data.add(re.getString("gogak_name"));
				data.add(re.getString("gogak_hp"));
				data.add(re.getString("gogak_addr"));
				
				item.model.addRow(data);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, pst, co);
		}
		
		
	}
	public void SearchGogak(GogakInfo item) {
		String sql ="";
		String searchText = item.jsearch.getText().trim();
		if (item.jsearch.getText().trim().isEmpty()) {
	        SelectGogak(item); 
	        return;
		}
		else {
	        if (isNumeric(searchText)) {
	            sql = "select c.num, car_name, car_made, car_color, gogak_name, gogak_hp, gogak_addr " +
	                    "from car c, gogak g where c.num = g.num and c.num = ?";
	        } else {
	            sql = "select c.num, car_name, car_made, car_color, gogak_name, gogak_hp, gogak_addr " +
	                    "from car c, gogak g where c.num = g.num and gogak_name = ?";
	        }
	    }

	    Connection co = db.getConnection();
	    PreparedStatement pst = null;
	    ResultSet re = null;

	    try {
	        pst = co.prepareStatement(sql);
	        if (isNumeric(searchText)) {
	            pst.setString(1, searchText);
	        } else {
	            pst.setString(1, searchText);
	        }
			re = pst.executeQuery();

			item.model.setRowCount(0);
			
			while (re.next()) {
				
				Vector<String> data = new Vector<String>();
				
				data.add(re.getString("num"));
				data.add(re.getString("car_name"));
				data.add(re.getString("car_made"));
				data.add(re.getString("car_color"));
				data.add(re.getString("gogak_name"));
				data.add(re.getString("gogak_hp"));
				data.add(re.getString("gogak_addr"));
				
				item.model.addRow(data);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, pst, co);
		}
	}
	private boolean isNumeric(String str) {
	    try {
	        Integer.parseInt(str); // 문자열을 정수로 변환 가능하면 숫자
	        return true;
	    } catch (NumberFormatException e) {
	        return false; // 숫자가 아니면 문자열
	    }
}
	
	public void CancelBuy(GogakInfo delete) {
		Connection co = db.getConnection();
		PreparedStatement pst = null;
		int selectedRow = delete.table.getSelectedRow();
		int num = Integer.parseInt(delete.table.getValueAt(selectedRow, 0).toString());
		
		String sql = "update car set car_sold = 0 where num = ?";
		String sql2 = "delete from gogak where num = ?";
		try {
			pst = co.prepareStatement(sql);
			pst.setInt(1, num);
			pst.executeUpdate();
			
			pst = co.prepareStatement(sql2);
			pst.setInt(1, num);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		}
	}
	

