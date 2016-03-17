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
		fullName()
		userName()
		email()
		website()
		bio maxSize:5000
	}
}
