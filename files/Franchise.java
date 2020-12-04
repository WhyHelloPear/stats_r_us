import java.util.*;

public class Franchise{
	private String id;
	private String name;
	private Boolean active;
	private List<String> teams;
	

	public Franchise(String id, String name, Boolean active){
	    this.id = id;
	    this.name = name;
	    this.active = active;
	    this.teams = new ArrayList<String>();
	}

	public String get_id(){
		return this.id;
	}

	public String get_name(){
		return this.name;
	}

	public Boolean is_active(){
		return this.active;
	}

	public void add_team(String id){
		if(this.teams.contains(id) == false){
			this.teams.add(id);
		}
	}

	public Boolean contains_team(String id){
		Boolean value = false;
		if(teams.contains(id)){
			value = true;
		}
		return value;
	}

}
