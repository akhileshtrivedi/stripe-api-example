package com.at.stripeapiexample.util;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.stripe.model.Token;
import java.util.HashMap;
import java.util.Map;


public class AddCardToCustomer {

	public static void main(String[] args) throws StripeException {

		Stripe.apiKey="sk_test_51Ora1bSA2AKqsLi9xMOubPCFfoKqeXjI8TNS43YDLcXrlqlANkkZJQWhuBUZW4SPoHutQzlWKh4UQ83AyS89B7Zz00jIlRFPQx"; //add your api key


		//System.out.println("API Key : " + stripeKey);
		//for updated code, check here : https://github.com/talenteddeveloper/Stripe-api/edit/master/AddCardToCustomerUpdatedCode.java

		//Customer customer = Customer.retrieve("cus_NffrFeUfNV2Hib");
		Customer customer = Customer.retrieve("cus_PhU21V64J6thKx"); //add customer id here : it will start with cus_
		Map<String, Object> cardParam = new HashMap<String, Object>(); //add card details
		cardParam.put("number", "4321 1111 2222 3333");
		cardParam.put("exp_month", "11");
		cardParam.put("exp_year", "2026");
		cardParam.put("cvc", "123");

		Map<String, Object> tokenParam = new HashMap<String, Object>();
		tokenParam.put("card", cardParam);

		Token token = Token.create(tokenParam); // create a token

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("source", token.getId()); //add token as source

		Card card = (Card)customer.getSources().create(source); // add the customer details to which card is need to link
		String cardDetails = card.toJson();
		System.out.println("Card Details : " + cardDetails);
		customer = Customer.retrieve("cus_PhU21V64J6thKx");//change the customer id or use to get customer by id
		System.out.println("After adding card, customer details : " + customer);
		
		// sample output in stripe dashboard : https://github.com/talenteddeveloper/Stripe-api/blob/master/Added%20Card.jpg
	}
}
