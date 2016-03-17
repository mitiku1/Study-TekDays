package com.tekdays



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TekEvent)
class TekEventTests {

    void testToString() {
			def tekEvent = new TekEvent(name:'Groovy One',
				city: 'San Francisco',
				organizer: 'John Doe')
			assertEquals tekEvent.toString() , 'Groovy One, San Francisco'
    }

    void testBootStrap(){
    }

}
