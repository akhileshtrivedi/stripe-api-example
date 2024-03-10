package com.at.stripeapiexample.util;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import java.util.HashMap;
import java.util.Map;

public class ChargeCustomer {

	public static void main(String[] args) throws StripeException {
		Stripe.apiKey="sk_test_51Ora1bSA2AKqsLi9xMOubPCFfoKqeXjI8TNS43YDLcXrlqlANkkZJQWhuBUZW4SPoHutQzlWKh4UQ83AyS89B7Zz00jIlRFPQx"; //add your api key

		//Stripe.apiKey ="sk_test*******"; // add your api key
		Map<String, Object> params = new HashMap<>();
		params.put("amount", 3000);
		params.put("currency", "usd");
		params.put("customer", "cus_PhU21V64J6thKx");

		Charge charge = Charge.create(params);
		System.out.println(charge);
	}

}
