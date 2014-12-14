package com.database.hotel_info;

class ObjectHotelInfo {
	public String name;
	public String hotelId;
	public String hotelWard;

	public String hotelCounty;
	public String hotelCity;
	public String hotelFullAddress;
	public String hotelWebsite;
	public String hotelEmail;
	public String hotelPhone;
	
	public Integer star;
	public Integer singleCost;
	public Integer doubleCost;
	public Integer fourCost;
	
	public ObjectHotelInfo(){
		
	}
	//Set 
	public void setName(String name){
		this.name = name;
	}
	public void setHotelId(String Id){
		this.hotelId = Id;
	}
	public void setStar(Integer star){
		this.star = star;
	}
	
	public void setHotelWard(String hotelWard){
		this.hotelWard = hotelWard;
	}
	
	
	public void setHotelCounty(String county){
		this.hotelCounty = county;
	}
	
	public void setHotelCity(String city){
		this.hotelCity = city;
	}
	
	public void setHotelFullAddress(String address){
		this.hotelFullAddress = address;
	}
	public void setHotelWebsite(String website){
		this.hotelWebsite = website;
	}
	public void setHotelEmail(String email) {
		this.hotelEmail = email;
	}
	public void setHotelPhone(String phone){
		this.hotelPhone = phone;
	}
	public void setSingleCost(Integer cost){
		this.singleCost = cost;
	}
	public void setDoubleCost(Integer cost){
		this.doubleCost = cost;
	}
	public void setFourCost(Integer cost){
		this.fourCost = cost;
	}
	// Get
	public String getName(){
		return this.name;
	}
	public String getHotelId(){
		return this.getHotelId();
	}
	public Integer getStar(){
		return this.star;
	}
	public String getHotelWard(){
		return this.hotelWard;
	}
	public String getHotelCounty(){
		return this.hotelCounty;
	}
	public String getHotelCity(){
		return this.hotelCity;
	}
	public String getHotelWebsite(){
		return this.hotelWebsite;
	}
	public String getHotelEmail(){
		return this.hotelEmail;
	}
	public String getHotelPhone(){
		return this.hotelPhone;
	}
	public String getHotelFullAddress(){
		return this.hotelFullAddress;
	}
	public Integer getSingleCost(){
		return this.singleCost;
	}
	public Integer getDoubleCost(){
		return this.doubleCost;
	}
	public Integer getFourCost(){
		return this.fourCost;
	}
}
