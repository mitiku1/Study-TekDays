package com.tekdays

import org.springframework.dao.DataIntegrityViolationException

class TekMessageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index(Integer max) {
        redirect(action:"list",max:max,params:params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def list
        def count
        def event = TekEvent.get(params.id)
        if(event){
            list = TekMessage.findAllByEvent(event, params)
            count = TekMessage.countByEvent(event)
        }
        else {
            list = TekMessage.list(params)
            count = TekMessage.count()
        }
        render view:'ajaxIndex', model:[tekMessageInstanceList: list,
                                        tekMessageInstanceCount: count,
                                        event: event]
    }

    def create() {
        [tekMessageInstance: new TekMessage(params)]
    }

    def save() {
        def tekMessageInstance = new TekMessage(params)
        if (!tekMessageInstance.save(flush: true)) {
            render(view: "create", model: [tekMessageInstance: tekMessageInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'tekMessage.label', default: 'TekMessage'), tekMessageInstance.id])
        redirect(action: "show", id: tekMessageInstance.id)
    }

    def show(Long id) {
        def tekMessageInstance = TekMessage.get(id)
        if (!tekMessageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekMessage.label', default: 'TekMessage'), id])
            redirect(action: "list")
            return
        }

        [tekMessageInstance: tekMessageInstance]
    }

    def edit(Long id) {
        def tekMessageInstance = TekMessage.get(id)
        if (!tekMessageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekMessage.label', default: 'TekMessage'), id])
            redirect(action: "list")
            return
        }

        [tekMessageInstance: tekMessageInstance]
    }

    def update(Long id, Long version) {
        def tekMessageInstance = TekMessage.get(id)
        if (!tekMessageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekMessage.label', default: 'TekMessage'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (tekMessageInstance.version > version) {
                tekMessageInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tekMessage.label', default: 'TekMessage')] as Object[],
                          "Another user has updated this TekMessage while you were editing")
                render(view: "edit", model: [tekMessageInstance: tekMessageInstance])
                return
            }
        }

        tekMessageInstance.properties = params

        if (!tekMessageInstance.save(flush: true)) {
            render(view: "edit", model: [tekMessageInstance: tekMessageInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'tekMessage.label', default: 'TekMessage'), tekMessageInstance.id])
        redirect(action: "show", id: tekMessageInstance.id)
    }

    def delete(Long id) {
        def tekMessageInstance = TekMessage.get(id)
        if (!tekMessageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tekMessage.label', default: 'TekMessage'), id])
            redirect(action: "list")
            return
        }

        try {
            tekMessageInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'tekMessage.label', default: 'TekMessage'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tekMessage.label', default: 'TekMessage'), id])
            redirect(action: "show", id: id)
        }
    }


    def reply = {
        def parent = TekMessage.get(params.id)
        def tekMessageInstance = new TekMessage(parent:parent, 
                                                event:parent.event,
                                                subject:"RE: $parent.subject")
        render view:'create', model:['tekMessageInstance':tekMessageInstance]
    }
    def showDetail(){
        def tekMessageInstance = TekMessage.get(params.id)
        if (tekMessageInstance) {
            render(template:"details", model:[tekMessageInstance:tekMessageInstance])
        }
        else {
            render "No message found with id: ${params.id}"
        }
    }
}
