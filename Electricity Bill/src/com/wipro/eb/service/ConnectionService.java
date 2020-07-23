package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) 
			throws InvalidReadingException, InvalidConnectionException
			{
		      if(currentReading<0||previousReading<0||currentReading<previousReading)
		      {
		    	  throw new InvalidReadingException();
		      }
		      else if(!(type.equals("Domestic")||type.equals("Commercial")))
		    		  {
		    	  throw new InvalidConnectionException();
		    		  }
		      return true;
			}
	public float calculateBillAmt(int currentReading, int previousReading, String type)
	{
		try {
			validate(currentReading,previousReading,type);
			if(type.equals("Domestic")){
				float[] slabs={2.3f,4.2f,5.5f};
				Domestic d=new Domestic(previousReading,currentReading,slabs);
				return d.computeBill();
				
			}
			else
			{
				float[] slabs={5.2f,6.8f,8.3f};
				Commercial c=new Commercial(previousReading,currentReading,slabs);
				return c.computeBill();
			}
		} catch (InvalidReadingException e) {
			// TODO Auto-generated catch block
			return -1;
		} catch (InvalidConnectionException e) {
			// TODO Auto-generated catch block
			return -2;
		}
	}

	public String generateBill(int currentReading, int previousReading, String type)
	{
		double amount=calculateBillAmt(currentReading,previousReading,type);
		if(amount==-1)
		{
			return "IncorrectReading";
		}else if(amount==-2)
		{
			return "Invalid Connection Type";
		}
		else
		{
			return "Amount to be paid:"+amount;
		}
		
	}
}

