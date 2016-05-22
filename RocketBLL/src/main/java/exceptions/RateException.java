package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	private RateDomainModel model;

	public RateException(RateDomainModel model){
		this.model = model;
	}
	
	public RateDomainModel getModel(){
		return model;
	}
	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}
