package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {
	private double r;
	private double n;
	private double p;
	private double f;
	private boolean t;
	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			//	TODO - RocketHub.messageReceived
			int icreditscore = lq.getiCreditScore();
			
			try{
				double iinterestrate = RateBLL.getRate(icreditscore);
				//call RateBLL.getPayment
				double payment = RateBLL.getPayment(r,n,p,f,t);
				// call setter for lq to update rate and payment
				double dRate = lq.setdRate(dRate);
				double dPayment = lq.setdPayment(dPayment);
				// send lq back to caller
			}
			catch(RateException e){
				//print error message
			}
			//	You will have to:
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			//		If exception, show error message, stop processing
			//		If no exception, continue
			//	Determine if payment, call RateBLL.getPayment
			//	
			//	you should update lq, and then send lq back to the caller(s)
			
			sendToAll(lq);
		}
	}
}
