public abstract class Record{
	private String type;
	private String league;
	private Franchise franchise;
	private String year;

	public Record(Franchise franchise, String league, String year, String type){
		this.franchise = franchise;
		this.year = year;
		this.type = type;
		this.league = league;
	}

	public void set_stats(){
		System.out.println("setting stats for record!");
	}

	public void get_type(){
		System.out.println(this.type);
	}

	public Franchise get_franchise() {
		return this.franchise;
	}

	public String get_year() {
		return this.year;
	}
}
