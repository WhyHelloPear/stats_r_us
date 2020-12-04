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

}
