package methodReference;

class Person{
	
	private String name;
	private int age;
	Person(String name,int age){
		 // This keyword refers to current instance itself
		this.name=name;  this.age=age;
	}	
	public Integer getAge() {	return age;	}
	public String getName() {	return name;}
}
