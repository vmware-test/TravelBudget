package org.demo.traveller.service.util;

import java.util.HashMap;
import java.util.Map;

import org.demo.traveller.vo.Country;
import org.demo.traveller.vo.Rate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class RestClient {

	private static final Logger log = LoggerFactory.getLogger(RestClient.class);
	
	public static Rate geRates(String baseCurrency)
	{
		// TODO put in properties file
	    final String uri = "https://api.exchangeratesapi.io/latest?base={base}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("base", baseCurrency);
	     
	    RestTemplate restTemplate = new RestTemplate();
	    Rate rate = restTemplate.getForObject(uri, Rate.class, params);
	     
	    log.debug(rate.toString());
	    return rate;
	}
	
	public static Country[] getNeighbors(String country)
	{
		// TODO put in properties file
	    final String uri = "https://api.geodatasource.com/neighbouring-countries?format=json&country_code= {base}&key=FJ0LKUGSQGBRBZ0RCO8WDASKCLRS4HCG";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("base", country);

	    RestTemplate restTemplate = new RestTemplate();
	    Country[] countries = restTemplate.getForObject(uri, Country[].class, params);

	    log.debug(countries.toString());
	    return countries;
	}
}