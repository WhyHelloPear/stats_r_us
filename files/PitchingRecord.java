public class PitchingRecord extends PlayerRecord{
	Integer wins; //W
	Integer losses; //L
	Integer games; //G
	Integer games_started; //GS
	Integer games_finished; //GF
	Integer complete_games; //CG
	Integer shutouts; //SHO
	Integer saves; //SV
	Integer outs_pitched; //IPOuts
	Integer hits; //H
	Integer earned_runs; //ER
	Integer home_runs; //HR
	Integer walks; //BB
	Integer strike_outs; //SO
	Float opp_batting_avg; //BAOpp
	Float era; //ERA
	Integer intentional_walks; //IBB
	Integer wild_pitches; //WP
	Integer bat_hit_by_pitch; //BHP
	Integer balks; //BK
	Integer batters_faced; //BFP
	Integer runs_allowed; //R

	public PitchingRecord(Franchise franchise, String league, String year){
		super(franchise, league, year, "pitching");
	}

	public void set_stats(Integer wins, Integer losses, Integer games, Integer games_started, Integer games_finished, Integer complete_games, Integer shutouts, Integer saves, Integer outs_pitched, Integer hits, Integer earned_runs, Integer home_runs, Integer walks, Integer strike_outs, Float opp_batting_avg, Float era, Integer intentional_walks, Integer wild_pitches, Integer bat_hit_by_pitch, Integer balks, Integer batters_faced, Integer runs_allowed){
		this.wins = wins;
		this.losses = losses;
		this.games = games;
		this.games_started = games_started;
		this.games_finished = games_finished;
		this.complete_games = complete_games;
		this.shutouts = shutouts;
		this.saves = saves;
		this.outs_pitched = outs_pitched;
		this.hits = hits;
		this.earned_runs = earned_runs;
		this.home_runs = home_runs;
		this.walks = walks;
		this.strike_outs = strike_outs;
		this.opp_batting_avg = opp_batting_avg;
		this.era = era;
		this.intentional_walks = intentional_walks;
		this.wild_pitches = wild_pitches;
		this.bat_hit_by_pitch = bat_hit_by_pitch;
		this.balks = balks;
		this.batters_faced = batters_faced;
		this.runs_allowed = runs_allowed;
	}
}
