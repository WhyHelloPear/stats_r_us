public class Manager extends Person{
	
	public Manager(String id, String name, Integer age, String birthplace, Integer weight, Integer height, String bats, String throw_arm, String playSpan){
	    super(id, name, age, birthplace, weight, height, bats, throw_arm, playSpan);
	}

	public void get_type(){
		System.out.println("Manager");
	}
}
