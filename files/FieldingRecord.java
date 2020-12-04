public class FieldingRecord extends PlayerRecord{
	String position;
	Integer games; //G
	Integer games_started; //GS
	Integer putouts; //PO
	Integer assists; //A
	Integer errors; //E
	Integer double_plays; //DP
	Integer passed_balls; //PB
	Integer wild_pitches; //WP
	Integer stolen_bases; //SB
	Integer caught_stealing; //CS
	
	public FieldingRecord(Franchise franchise, String league, String year){
		super(franchise, league, year, "fielding");
	}

	public void set_stats(String position, Integer games,Integer games_started,Integer putouts, Integer assists,Integer errors,Integer double_plays,Integer passed_balls, Integer wild_pitches, Integer stolen_bases, Integer caught_stealing){
		this.position = position;
		this.games = games;
		this.games_started = games_started;
		this.putouts = putouts;
		this.assists = assists;
		this.errors = errors;
		this.double_plays = double_plays;
		this.passed_balls = passed_balls;
		this.wild_pitches = wild_pitches;
		this.stolen_bases = stolen_bases;
		this.caught_stealing = caught_stealing;
	}
}
