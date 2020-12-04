public class ManagerRecord extends Record{
	Person manager;
	Integer games_played;
	Integer games_won;
	Integer games_lost;
	Integer rank;


	public ManagerRecord(Franchise franchise, String league, String year){
		super(franchise, league, year, "manager");
	}

	public void set_stats(Person manager, Integer games_played, Integer games_won, Integer games_lost, Integer rank){
		this.manager = manager;
		this.games_played = games_played;
		this.games_won = games_won;
		this.games_lost = games_lost;
		this.rank = rank;
	}


}
