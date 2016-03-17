package com.tekdays

class TekEvent {
	String city
	String name
	TekUser organizer
	String venue
	Date startDate
	Date endDate
	String description



    static constraints = {
    	city()
    	name()
    	organizer()
    	venue()
    	startDate()
    	endDate()
    	description maxSize :5000
    	volunteers nullable:true
    	sponsorships nullable:true
    	tasks nullable: true
		messages nullable: true


	}
    static searchable=true

    String toString(){
    	"$name, $city"
    }


    static hasMany=[
    				volunteers:TekUser,
    				respondents:String,
    				sponsorships:Sponsorship,
    				tasks:Task ,
    				messages:TekMessage


    				]
}
