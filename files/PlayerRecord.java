abstract class PlayerRecord extends Record{

	Person player;

	public PlayerRecord(Franchise franchise, String league, String year, String type){
		super(franchise, league, year, type);
	}

	public void set_player(Person player){
		this.player = player;
	}

	public Person get_player(){
		System.out.println(this.player.get_name());
		return this.player;
	}

}
