package org.pih.warehouse.product;

import java.util.Date;

class Category {

	String name
	String description
	Integer sortOrder = 0;
	Category parentCategory
	Date dateCreated;
	Date lastUpdated;
	
	static hasMany = [ categories : Category ];
	static mappedBy = [ categories : "parentCategory" ];
	static belongsTo = [ parentCategory : Category ];
	
	static mapping = {
		sort name:"desc"
		categories sort:"name"
	}
	
	static constraints = {
		name(nullable:false)
		description(nullable:true)
		sortOrder(nullable:true)
		parentCategory(nullable:true)
	}  
	
	String toString() { return "$name"; }
	

	
	                     
	
}