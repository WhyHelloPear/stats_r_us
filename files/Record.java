public abstract class Record{
	String type;
	String league;
	Franchise franchise;
	String year;

	public Record(Franchise franchise, String league, String year, String type){
		this.franchise = franchise;
		this.year = year;
		this.type = type;
		this.league = league;
	}

	public void set_stats(){
		System.out.println("setting stats for record!");
	}
}
