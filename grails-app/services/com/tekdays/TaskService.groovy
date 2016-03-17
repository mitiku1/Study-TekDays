package com.tekdays

class TaskService {

    def serviceMethod() {

    }
    def addDefaultTasks(tekEvent){
		if (tekEvent.tasks?.size() > 0)
			return //We only want to add tasks to a new event
		tekEvent.addToTasks 	new Task(title:'Identify potential venues',completed:false)
		tekEvent.addToTasks		new Task(title:'Get price / availability of venues',completed:false)
		tekEvent.addToTasks		new Task(title:'Compile potential sponsor list',completed:false)
		tekEvent.addToTasks		new Task(title:'Design promotional materials',completed:false)
		tekEvent.addToTasks		new Task(title:'Compile potential advertising avenues',completed:false)
		tekEvent.addToTasks		new Task(title:'Locate swag provider (preferably local)',completed:false)
		tekEvent.save()
		
		
		
		
		
		
	}
}
