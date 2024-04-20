package com.example.demo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateConversionController {
	
	@GetMapping("/convert/{dateString}")
	public String convertDate(@PathVariable String dateString ) {
		try {
			SimpleDateFormat inputFormat=new SimpleDateFormat("dd MMMM,yyyy");
			Date date=inputFormat.parse(dateString);
			SimpleDateFormat outputFormat=new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate=outputFormat.format(date);
			return formattedDate;
		}
		catch(ParseException e) {
			e.printStackTrace();
			return "Error: Unable to parse the input date.";
		}
	}

}
