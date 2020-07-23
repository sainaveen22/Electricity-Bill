package com.wipro.eb.entity;

public class Domestic extends Connection {

	public Domestic(int previousReading, int currentReading, float[] slabs) {
		super(previousReading, currentReading, slabs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float computeBill() {
		// TODO Auto-generated method stub
		int consumerUnits=currentReading-previousReading;
		float billAmount=0.0f;
		if(consumerUnits>100)
		{
			billAmount=(consumerUnits-100)*slabs[2]+50*slabs[1]+50*slabs[0];
		}
		else if(consumerUnits>50)
		{
			billAmount=(consumerUnits-50)*slabs[1]+50*slabs[0];
		}
		else
		{
			billAmount=consumerUnits*slabs[0];
		}
		return billAmount;
	}
	
	

}
