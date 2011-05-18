package org.pih.warehouse

import java.text.SimpleDateFormat;
import org.pih.warehouse.core.Person;

class JqueryDateTagLib {
		

	def jqueryDatePicker = {attrs, body ->
		
		def id = attrs.id ? attrs.id : attrs.name;
		def name = attrs.name;
		def autoSize = attrs.autoSize ?:(attrs.size)?"false":"true";
		def size = attrs.size ?: "10"
		def showOn = attrs.showOn ?: "both";
		def showTrigger = Boolean.valueOf(attrs.showTrigger ?: "true");
				
		def value = attrs.value
		if (value instanceof Date) {
			value = (attrs.format && attrs.value) ? new SimpleDateFormat(attrs.format).format(attrs.value) : ""
		}
	
		if (name == null) {
			throw new IllegalArgumentException("name parameter must be specified")
		}
		
		def html = """

		<span>
			<input id='${id}' name='${name}' type='hidden'/>
			<input id='${id}-datepicker' name='${name}-datepicker' type='text' class='date' size="${size}" />
			<script type=\'text/javascript\'>
				jQuery(document).ready(function() {
					jQuery('#${id}-datepicker').datepicker({
						altField: '#${id}',
						altFormat: 'mm/dd/yy',
						dateFormat: 'dd/M/yy',
						autoSize: ${autoSize},
						showOn: '${showOn}',
						buttonImageOnly: true,
						buttonImage: '/warehouse/images/icons/silk/calendar.png',
						//buttonText: '...',
						//showButtonPanel: true,
						//showOtherMonths: true,
						//selectOtherMonths: true
					});
					var dateValue = '${value}';
					if (dateValue) {
						jQuery('#${name}-datepicker').datepicker('setDate', new Date('${value}'));
					}
				});
			</script>
		</span>
		""";

		if (showTrigger) {
			html += """
			<style>
			.ui-datepicker-trigger {
				position: relative; left: -20px; top: -2px;
			}
			</style>
			""";
		}
		
				
		out << html;
				
	}
	
	
}