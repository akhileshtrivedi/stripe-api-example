package com.at.stripeapiexample.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import java.util.HashMap;
import java.util.Map;

public class ListCustomers {

	public static void main(String[] args) throws StripeException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Stripe.apiKey="sk_test_51Ora1bSA2AKqsLi9xMOubPCFfoKqeXjI8TNS43YDLcXrlqlANkkZJQWhuBUZW4SPoHutQzlWKh4UQ83AyS89B7Zz00jIlRFPQx"; //add your api key

		
		Map <String, Object> params = new HashMap<>();
		//params.put("limit",3);

		params.put("email","v@b.com");
		CustomerCollection customers = Customer.list(params);
		String a = customers.toJson();
		System.out.println(a);
	}

}
