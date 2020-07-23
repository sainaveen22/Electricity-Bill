package com.wipro.eb.entity;

public class Commercial extends Connection{

	public Commercial(int previousReading, int currentReading, float[] slabs) {
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
		if(billAmount>=10000)
		{
			billAmount*=1.09f;
		}
		else if(billAmount>=5000)
		{
			billAmount*=1.06f;
		}
		else
		{
			billAmount*=1.02f;
		}
		return billAmount;
	}
	

}
