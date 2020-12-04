public class FranchiseRecord extends Record{
	Integer rank;
	Integer games;
	Integer games_won;
	Integer games_lost;
	Integer runs; //R
	Integer at_bats; //AB
	Integer hits; //H
	Integer doubles; //2b
	Integer tripes; //3b
	Integer home_runs; //HR
	Integer walks; //BB
	Integer strike_outs; //SO
	Integer stolen_bases; //SB
	Integer caught_stealing; //CS
	Integer hit_by_pitch; //HBP
	Integer sacrifice_flies; //SF
	Integer earned_runs; //ER
	Float earned_runs_average; //ERA
	Integer errors; //E



	public FranchiseRecord(Franchise franchise, String league, String year){
		super(franchise, league, year, "franchise");
	}

}
