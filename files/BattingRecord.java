public class BattingRecord extends PlayerRecord{
	Integer games; //G
	Integer at_bats; //AB
	Integer runs; //R
	Integer hits; //H
	Integer doubles; //2b
	Integer triples; //3B
	Integer home_runs; //HR
	Integer rbi; //RBI
	Integer stolen_bases; //SB
	Integer caught_stealing; //CS
	Integer walks; //BB
	Integer strike_outs;
	Integer intentional_walks; //IBB
	Integer hit_by_pitch; //HBP
	Integer sacrifice_hits; //SH
	Integer sacrifice_flies; //SF
	Integer grounded_into_double_play; //GIDP

	public BattingRecord(Franchise franchise, String league, String year){
		super(franchise, league, year, "batting");
	}


	public void set_stats(Integer games, Integer at_bats, Integer runs, Integer hits, Integer doubles, Integer triples, Integer home_runs, Integer rbi, Integer stolen_bases, Integer caught_stealing, Integer walks, Integer strike_outs, Integer intentional_walks, Integer hit_by_pitch, Integer sacrifice_hits, Integer sacrifice_flies, Integer grounded_into_double_play){
		this.games = games;
		this.at_bats = at_bats;
		this.runs = runs;
		this.hits = hits;
		this.doubles = doubles;
		this.triples = triples;
		this.home_runs = home_runs;
		this.rbi = rbi;
		this.stolen_bases = stolen_bases;
		this.caught_stealing = caught_stealing;
		this.walks = walks;
		this.strike_outs = strike_outs;
		this.intentional_walks = intentional_walks;
		this.hit_by_pitch = hit_by_pitch;
		this.sacrifice_hits = sacrifice_hits;
		this.sacrifice_flies = sacrifice_flies;
		this.grounded_into_double_play = grounded_into_double_play;
	}


}
