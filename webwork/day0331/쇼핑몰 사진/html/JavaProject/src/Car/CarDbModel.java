package Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;

import Car.InsertCar.Mycanvas;

public class CarDbModel {

	DBConnect db = new DBConnect();

	   public void SelectCar(CarMain item, int select) {
		   String sql="";
		   if(select==1)
			   sql = "select num , car_name, car_made, car_color , car_fuel||'Km/L' car_fuel,to_char(car_pay,'999,999,999')||'원'"
			   		+ "car_pay,to_char(car_day,'YYYY-MM-DD')car_day from car where Car_sold = 0 order by num";
		   else if(select==2)
			   sql = "select num , car_name, car_made, car_color , car_fuel||'Km/L' car_fuel,to_char(car_pay,'999,999,999')||'원'"
			   		+ "car_pay,to_char(car_day,'YYYY-MM-DD')car_day from car where Car_sold = 0 order by car_made";
		   else if(select==3)
			   sql = "select num , car_name, car_made, car_color , car_fuel||'Km/L' car_fuel,to_char(car_pay,'999,999,999')||'원'"
			   		+ "car_pay,to_char(car_day,'YYYY-MM-DD')car_day from car where Car_sold = 0 order by car_fuel";
		   else if(select==4)
			   sql = "select num , car_name, car_made, car_color , car_fuel||'Km/L' car_fuel,to_char(car_pay,'999,999,999')||'원'"
			   		+ "car_pay,to_char(car_day,'YYYY-MM-DD')car_day from car where Car_sold = 0 order by car_pay";
		   
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
					data.add(re.getString("car_fuel"));
					data.add(re.getString("car_pay"));
					data.add(re.getString("car_day"));
					
					item.model.addRow(data);
				}
		   }catch (SQLException e) {
				e.printStackTrace();
			}finally {
				db.dbClose(re, pst,co);
			}	   
	   }
/////////////////////////////////////////Insert//////////////////////////////////////////////////////	   
	   public void InsertCar(InsertCar insert) {
		   Connection co = db.getConnection();
		   PreparedStatement pst = null;
		   
		   String sql = "insert into car(num,car_name,car_made,car_color,car_fuel,car_pay,car_day) values(seq_car.nextval, ?,?,?,?,?,sysdate)";
		   
		   try {
			pst = co.prepareStatement(sql);
			
			pst.setString(1, (String)insert.jname.getSelectedItem());
			pst.setString(2, (String)insert.jmade.getSelectedItem());
			pst.setString(3, (String)insert.jcolor.getSelectedItem());
			pst.setString(5, (String)insert.fuel.getText());
			pst.setString(4, (String)insert.pay.getText());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(pst, co);
		}
		   
	   }
/////////////////////////////////////////Update//////////////////////////////////////////////////////	
	   public void UpdateCar(UpdateCar update, CarMain swing) {
		   Connection co = db.getConnection();
		   PreparedStatement pst = null;
		   
		   int selectedRow = swing.table.getSelectedRow();
		   int num = Integer.parseInt(swing.table.getValueAt(selectedRow, 0).toString());
		   String sql = "update car set car_name = ?, car_made = ?, car_color = ?"
		   		+ ",car_fuel = ?,car_pay = ? where num = ?";
		   
		   try {
			pst = co.prepareStatement(sql);
			
			pst.setString(1, (String)update.jname.getSelectedItem());
			pst.setString(2, (String)update.jmade.getSelectedItem());
			pst.setString(3, (String)update.jcolor.getSelectedItem());
			pst.setString(4, (String)update.fuel.getText());
			pst.setString(5, (String)update.pay.getText());
			pst.setInt(6, num);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(pst, co);
		}
	   }
/////////////////////////////////////////Delete//////////////////////////////////////////////////////
	   public void DelteCar(CarMain delete) {
		   Connection co = db.getConnection();
		   PreparedStatement pst = null;
		   
		   String sql = "delete car where num = ?";
			
		    int selectedRow = delete.table.getSelectedRow();
			int num = Integer.parseInt(delete.table.getValueAt(selectedRow, 0).toString());
		   try {
			pst = co.prepareStatement(sql);

			pst.setInt(1, num);
			pst.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			db.dbClose(pst, co);
		}
	   }
/////////////////////////////////////////Gogak_buy//////////////////////////////////////////////////////
	   public void CarBuy(Car_Gogak gogak, CarMain main) {
		   Connection co = db.getConnection();
		   PreparedStatement pst = null;
		   
		   String sql = "insert into gogak values(?,?,?,?)";
		   
		   int selectedRow = main.table.getSelectedRow();
		   int num = Integer.parseInt(main.table.getValueAt(selectedRow, 0).toString());
		   
		   try {
			pst = co.prepareStatement(sql);
			
			pst.setInt(1, num);
			pst.setString(2, (String)gogak.gogak_name.getText());
			pst.setString(3, (String)gogak.gogak_hp.getText());
			pst.setString(4, (String)gogak.gogak_addr.getText());
			
			pst.executeUpdate();
			
			String updateSql = "update car set car_sold = 1 where num = ?";
	        pst = co.prepareStatement(updateSql);
	        pst.setInt(1, num);
	        pst.executeUpdate();
	        
	        SelectCar(main, 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(pst, co);
		}
		   
		   
	   }
   }


