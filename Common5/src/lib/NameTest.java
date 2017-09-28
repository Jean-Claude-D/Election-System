package lib;

public class NameTest {

	public static void main(String[] args) {
		
		try {
			Name person1 = new Name("John", "Cena");
			Name person2 = new Name("THE WAR", "too'aaa");
			Name person3 = new Name("Hans", "Get Z'e FLAMMEN-WERFER");
			
		}
		catch (IllegalArgumentException ex){
			System.out.println("ALPHA DOWN " + ex);
		}
		
		try {
			Name person4 = new Name("J#ohn", "!Cena");
			Name person5 = new Name("THE?WAR", "21to12 ' (END) -- ALL_WAR");
			Name person6 = new Name("Ha---ns", "Get   Z'''e FLA M MEN-WERFER");	
		}
		catch (IllegalArgumentException ex){
			System.out.println("BETA DOWN");
		}
		
		try {
			Name person4 = new Name("J", "Cena!");
			Name person5 = new Name("John", "C");
			Name person6 = new Name("---", "''''''    --- EN-WERFER");	
		}
		catch (IllegalArgumentException ex){
			System.out.println("CHARLIE DOWN");
		}

		Name person1 = new Name("Hans", "Get Z'e FLAMMEN-WERFER");
		Name person2 = new Name("Austin", "Antoine");
		
		System.out.println(person1.getFullName());
		System.out.println(person1.getFirstname());
		System.out.println(person1.getLastname());
		System.out.println("------------------------------");
		
		System.out.println(person1.toString());
		
		Name copyPerson1 = new Name(person1);
		System.out.println("------------------------------");
		System.out.println(copyPerson1.getFullName());
		System.out.println(copyPerson1.getFirstname());
		System.out.println(copyPerson1.getLastname());
		System.out.println("------------------------------");
		
		int a = person1.compareTo(copyPerson1);
		int b = person1.compareTo(person2);
		
		System.out.println("a= " + a + " and b= " + b);
		
		
		
		
	}
	

}
