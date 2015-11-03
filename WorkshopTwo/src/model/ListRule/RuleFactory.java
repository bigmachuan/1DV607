package model.ListRule;

public class RuleFactory {
	
	public IListRule getAgeList(){
		return new AgeList();
	}
	
	public IListRule getMonthList(){
		return new MonthList();
	}
	
	public IListRule getNameList(){
		return new NameList();
	}
	

}
