package controller;

import java.util.Vector;

public class ConcretePromotionListSubject implements PromotionListSubject
{

	private Vector<String> thePromotionList;
	private Vector<RegisteredBuyerObserver> observers;
	
	public ConcretePromotionListSubject(Vector<String> promotionlist)
	{
		thePromotionList = promotionlist;
		observers = new Vector<RegisteredBuyerObserver>();
	}
	
	@Override
	public void register(RegisteredBuyerObserver o)
	{
		observers.addElement(o);
	}

	@Override
	public void unregister(RegisteredBuyerObserver o)
	{
		observers.remove(o);
	}

	@Override
	public void notifyAllObservers()	// notifies all registered buyers (updates their promotion list)
	{
		for(int i = 0; i < observers.size(); i++)
			observers.get(i).update(thePromotionList);
	}

	
}
