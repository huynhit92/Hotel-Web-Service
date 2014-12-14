package com.database.hotel_info;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import com.database.connect.*;
import com.database.hotel_info.ObjectHotelInfo;


public class HotelInfo {
	public ConnectDatabase connectDatabase;
	public ObjectHotelInfo objectHotel;
	public HotelInfo() throws ClassNotFoundException{
		connectDatabase = new ConnectDatabase();
		objectHotel		= new ObjectHotelInfo();
	}
	
	/**
	 *Them khach san moi 
	 *
	 *version 1.0
	 *
	 * @param id
	 * @param name
	 * @param star
	 * @param ward
	 * @param county
	 * @param city
	 * @param full_address
	 * @param website
	 * @param email
	 * @param phone
	 * @param total_room
	 * @param single_room_available
	 * @param double_room_available
	 * @param four_people_room_available
	 * @param single_cost
	 * @param double_cost
	 * @param four_cost
	 * @throws SQLException
	 */
	
	public void addNewHotel(String id,String name, Integer star, String ward, String county, String city, String full_address, String website, String email, String phone, Integer total_room, Integer single_room_available, Integer double_room_available, Integer four_people_room_available, Integer single_cost, Integer double_cost, Integer four_cost ) throws SQLException {
		String insertSql = "INSERT INTO hotel_info " + "VALUES ('"+id+"','"+name+"','"+star+"','"+ward+"','"+county+"','"+city+"','"+full_address+"','"+website+"','"+email+"','"+phone+"','"+total_room+"','"+single_room_available+"','"+double_room_available+"','"+four_people_room_available+"','"+single_cost+"','"+double_cost+"','"+four_cost+"')";
		this.connectDatabase.stm.executeUpdate(insertSql);
	}
	
	/**
	 * Tim kiem khach san theo thanh pho hoac thanh pho va quan huyen
	 * Tra ve mang chua thong tin cac khach san tim duoc
	 * @param city
	 * @param ward
	 * @return ObjectHotelInfo[]
	 * @throws SQLException
	 */
	
	public ObjectHotelInfo[] findHotelByCity( String city,String ward) throws SQLException{
		String findByCitySql 		= "Select * from hotel_info where hotel_city = '"+city+"' ";
		String findByCityAndWardSql = "Select * from hotel_info where hotel_city = '"+city+"' AND hotel_ward = '"+ward+"' ";
		List<ObjectHotelInfo> list = new ArrayList<ObjectHotelInfo>();
		ResultSet rs;
		if(ward == null){
			 rs  = this.connectDatabase.stm.executeQuery(findByCitySql);
		}
		else{
			rs = this.connectDatabase.stm.executeQuery(findByCityAndWardSql);
		}
		list = getHotelListFromResultSet(rs);
		return list.toArray(new ObjectHotelInfo[list.size()]);
	}
	/**
	 * Tim kiem khach san theo cac tham so nhu City , Date, Cost
	 * @param city
	 * @param checkInDate
	 * @param checkOutDate
	 * @param numberOfDay
	 * @param singleRoom
	 * @param doubleRoom
	 * @param fourRoom
	 * @return
	 * @throws SQLException
	 */
	public ObjectHotelInfo[] findHotelByCityDateNumberOfRoom(String city,String checkInDate,String checkOutDate,
															Integer numberOfDay,Integer singleRoom,
															Integer doubleRoom,Integer fourRoom) throws SQLException{
		
		String sql = "select * from hotel_info where hotel_city = '"+city+ "' AND '"+singleRoom+"' <= single_room_available "
																		  + "AND '"+doubleRoom+"' <= double_room_available "
																		  + "AND '"+fourRoom+"' <= four_people_room_available ";
		List<ObjectHotelInfo> list = new ArrayList<ObjectHotelInfo>();
		ResultSet rs = this.connectDatabase.stm.executeQuery(sql);
		list = getHotelListFromResultSet(rs);
		return list.toArray(new ObjectHotelInfo[list.size()]);
	}
	/**
	 * Chuyen ket qua tu result set thanh danh sach cac khach san
	 * @param rs
	 * @return
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public List<ObjectHotelInfo> getHotelListFromResultSet(ResultSet rs) throws NumberFormatException, SQLException{
		List<ObjectHotelInfo> list = new ArrayList<ObjectHotelInfo>();
		while(rs.next()){
			ObjectHotelInfo object = new ObjectHotelInfo();
			object.setName(rs.getString("hotel_name"));
			object.setHotelId(rs.getString("hotel_id"));
			object.setStar(Integer.parseInt(rs.getString("hotel_star")));
			object.setHotelWard(rs.getString("hotel_ward"));
			object.setHotelCity(rs.getString("hotel_city"));
			object.setHotelCounty(rs.getString("hotel_county"));
			object.setHotelFullAddress(rs.getString("hotel_full_address"));
			object.setHotelWebsite(rs.getString("hotel_website"));
			object.setHotelEmail("hotel_email");
			object.setHotelPhone(rs.getString("hotel_phone"));
			object.setSingleCost(Integer.parseInt(rs.getString("single_room_cost")));
			object.setDoubleCost(Integer.parseInt(rs.getString("double_room_cost")));
			object.setFourCost(Integer.parseInt(rs.getString("four_people_room_cost")));
			list.add(object);
		}
		return list;
	}
	/**
	 * Dat phong khach san
	 * @param hotelId
	 * @param company_name
	 * @param company_address
	 * @param company_phone
	 * @param numberSingleRoom
	 * @param numberDoubleRoom
	 * @param numberFourPeopleRoom
	 * @param checkInDate
	 * @param checkOutDate
	 * @param status
	 * @param paymentMethod
	 * @param singleCost
	 * @param doubleCost
	 * @param fourCost
	 * @throws SQLException 
	 */
	
	public void addNewContract(String  hotelId,              String company_name,       String  company_address,
							   String  company_phone,        Integer numberSingleRoom , Integer numberDoubleRoom,
							   Integer numberFourPeopleRoom, String checkInDate,        String  checkOutDate,
							   String paymentMethod,		Integer singleCost,
							   Integer doubleCost,			 Integer fourCost	 
							   
							 ) throws SQLException{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();

		String sql = "Insert into contract_hotel " + "VALUES(default,'"+hotelId+"','"+company_name+"','"+company_address+"',"
													+ "  		     '"+company_phone+"'  ,'"+numberSingleRoom+"','"+numberDoubleRoom+"',"
												    + "              '"+numberFourPeopleRoom+"','"+checkInDate+"','"+checkOutDate+"',0,"
												    + "              '"+paymentMethod+"' , '"+dateFormat.format(cal.getTime())+"','"+singleCost+"',"
												    + "              '"+doubleCost+"' , '"+fourCost+"' 	)"; 
		this.connectDatabase.stm.executeUpdate(sql);
	}
	public void updateContract(Integer contractId , Integer numberSingle ,Integer numberDouble,
							   Integer numberFour , Integer status	  , String  paymentMethod  ){
		
	}
	public static void main( String args[]) throws SQLException, ClassNotFoundException{
		HotelInfo hotelInfo = new HotelInfo();
		//hotelInfo.addNewHotel("CON","CONMEO", 5, "XA Dan", "DONG DA", "Ha Noi", "Xa Dan,Dong Da,Ha Noi", "www.conmeo.com/default-vi.html", "support@conmeo.con", "+84432515999", 300, 100, 150, 50, 200000, 300000, 600000);

		ObjectHotelInfo[] object = hotelInfo.findHotelByCity("Ha Noi",null);
		//System.out.printf( object[0].getHotelWard());
		//LinkedList<String> list = hotelInfo.findHotelByCity("Ha Noi");
		for ( int i = 0 ; i < object.length ; i ++ ){
			System.out.printf(object[i].getHotelFullAddress()+object[i].getDoubleCost()+"\n");
		}
		hotelInfo.addNewContract("DAE", "travel", "Kham Thien Ha noi", "0987666555", 10, 5, 0, "2014-12-23", "2014-12-29", "Visa", 200000, 300000, 700000);
	}
}

