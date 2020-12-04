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

}
