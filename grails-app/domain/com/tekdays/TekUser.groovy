package com.tekdays

class TekUser {

    String fullName
	String userName
	String password
	String email
	String website
	String bio
	String toString() { fullName }


	static searchable=true
	static constraints = {
		fullName(blank: false, minSize: 4,maxSize: 50)
		userName(unique:true,blank: false, minSize: 5,maxSize: 10)
		email(blank: false, email: true)
		website(nullable: true, blank: true ,url: true)
		bio (maxSize:5000,nullable: true,blank: true)
		password(blank: false,sminSize: 6,maxSize: 10)
	}
}
