public class Franchise{
	String id;
	String name;
	Boolean active;
	

	public Franchise(String id, String name, Boolean active){
	    this.id = id;
	    this.name = name;
	    this.active = active;
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

}
