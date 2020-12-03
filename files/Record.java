abstract class Record{
	String type;
	Person person;
	Franchise franchise;
	String year;
	List<String> categories;
	List<String> stats;


	public String getType(){
		return this.type;
	}

	public Record getBaseRecord(){
		return this;
	}
}
