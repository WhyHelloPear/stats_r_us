public abstract class Person{
	String id;
	String name;
	Integer age;
	String birthplace;
	Integer weight;
	Integer height;
	String bats;
	String throw_arm;
	String playSpan;
	

	public Person(String id, String name, Integer age, String birthplace, Integer weight, Integer height, String bats, String throw_arm, String playSpan){
	    this.id = id;
	    this.name = name;
	    this.age = age;
	    this.birthplace = birthplace;
	    this.weight = weight;
	    this.height = height;
	    this.bats = bats;
	    this.throw_arm = throw_arm;
	    this.playSpan = playSpan;
	}

	public String get_id(){
		return this.id;
	}

	public void get_type(){
		System.out.println("Person");
	}
}
