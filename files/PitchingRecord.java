public class PitchingRecord extends PlayerRecord{
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

}
