public class FranchiseRecord extends Record{
	Integer rank;
	Integer games;
	Integer games_won;
	Integer games_lost;
	Integer runs; //R
	Integer at_bats; //AB
	Integer hits; //H
	Integer doubles; //2b
	Integer triples; //3b
	Integer home_runs; //HR
	Integer walks; //BB
	Integer strike_outs; //SO
	Integer stolen_bases; //SB
	Integer caught_stealing; //CS
	Integer hit_by_pitch; //HBP
	Integer sacrifice_flies; //SF
	Integer earned_runs_allowed; //ER
	Float earned_runs_average; //ERA
	Integer complete_games; //CG
	Integer shutouts; //SHO
	Integer saves; //SV
	Integer hits_allowed; //HA
	Integer home_runs_allowed; //HRA
	Integer walks_allowed; //BBA
	Integer pitcher_strike_outs; //SOA
	Integer errors; //E
	Integer double_plays; //DP
	Float fielding_percentage; //FP



	public FranchiseRecord(Franchise franchise, String league, String year){
		super(franchise, league, year, "franchise");
	}

	public void set_stats(Integer rank, Integer games, Integer games_won, Integer games_lost, Integer runs, Integer at_bats, Integer hits, Integer doubles, Integer triples, Integer home_runs, Integer walks, Integer strike_outs, Integer stolen_bases, Integer caught_stealing, Integer hit_by_pitch, Integer sacrifice_flies, Integer earned_runs_allowed, Float earned_runs_average, Integer complete_games, Integer shutouts, Integer saves, Integer hits_allowed, Integer home_runs_allowed, Integer walks_allowed, Integer pitcher_strike_outs, Integer errors, Integer double_plays, Float fielding_percentage){
		this.rank = rank;
		this.games = games;
		this.games_won = games_won;
		this.games_lost = games_lost;
		this.runs = runs;
		this.at_bats = at_bats;
		this.hits = hits;
		this.doubles = doubles;
		this.triples = triples;
		this.home_runs = home_runs;
		this.walks = walks;
		this.strike_outs = strike_outs;
		this.stolen_bases = stolen_bases;
		this.caught_stealing = caught_stealing;
		this.hit_by_pitch = hit_by_pitch;
		this.sacrifice_flies = sacrifice_flies;
		this.earned_runs_allowed = earned_runs_allowed;
		this.earned_runs_average = earned_runs_average;
		this.complete_games = complete_games;
		this.shutouts = shutouts;
		this.saves = saves;
		this.hits_allowed = hits_allowed;
		this.home_runs_allowed = home_runs_allowed;
		this.walks_allowed = walks_allowed;
		this.pitcher_strike_outs = pitcher_strike_outs;
		this.errors = errors;
		this.double_plays = double_plays;
		this.fielding_percentage = fielding_percentage;
	}

}
