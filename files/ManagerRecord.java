public class ManagerRecord extends Record{
	Integer games_played;
	Integer games_won;
	Integer games_lost;
	Integer rank;


	public ManagerRecord(Franchise franchise, String league, String year){
		super(franchise, league, year, "manager");
	}

	public void set_stats(Integer games_played, Integer games_won, Integer games_lost, Integer rank){
		System.out.println("Setting stats for manager record!");
		this.games_played = games_played;
		this.games_won = games_won;
		this.games_lost = games_lost;
		this.rank = rank;
	}


}
