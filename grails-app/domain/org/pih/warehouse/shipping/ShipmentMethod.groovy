package org.pih.warehouse.shipping

import java.util.Date;

class ShipmentMethod {
	Shipper shipper					// If you just want to store the shipper information
	ShipperService shipperService	// the selected shipping service
	String trackingNumber			// should be part of a shipment mode: tracking number, carrier, service
	Date dateCreated;
	Date lastUpdated;
	
	static constraints = {
		shipper(nullable:true)
		shipperService(nullable:true)
		trackingNumber(nullable:true)
		//shipment(nullable:true)
	}
}