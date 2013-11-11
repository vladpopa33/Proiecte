package tests;
import static org.junit.Assert.*;
import domain.Lista;
import interfaces.ILista;


public class TestLista {

	ILista<String> list=new Lista<String>(String.class);
	
	/*@org.junit.Test
	public void test() {
		fail("Not yet implemented");
	}
*/
	@org.junit.After
	public void tearDown() throws Exception {
		System.out.println("Test terminat !");
	}
	
	@org.junit.Test
	public void Creare() {
		assertNotNull("Lista este vida !",list);
	}
	
	@org.junit.Test
	public void element() {
		System.out.println("fasss");
		list.add("3");
		assertTrue("Elementul nu apartine listei !",list.element(0)=="3");
	}
	
	@org.junit.Test
	public void add() {
		//System.out.println("TReaba serioasa");
		list.add("1");
		assertTrue("Functia <<add>> nu este valida ! ",list.element(0)=="1");
		list.add("5");
		assertTrue("Functia <<add>> nu este valida !", list.element(1)=="5");
		//System.out.println("TReaba serioasa");
	}
	
	@org.junit.Test
	public void delete() {
		list.add("1");//1
		list.add("2");
		list.add("10");//
		list.add("99");//
		list.add("33");
		list.delete(0);
		list.delete(1);
		list.delete(2);
		
		assertTrue("Functia <<delete>> nu este valida !", list.element(0)=="2");
		assertTrue("Functia <<delete>> nu este valida !", list.element(1)=="99");
		//assertTrue("Functia <<delete>> nu este valida !", list.element(4)==33);
	}
	
	@org.junit.Test
	public void size() {
		list.add("2");
		list.add("3");
		list.add("9");
		list.add("8");
		list.add("11");
		assertTrue("Functia <<size>> nu este valida !",list.size()==5);
	}
	
	@org.junit.Test
	public void vida() {
		System.out.println("Element adaugat cu succes!\n Program terminat.");
		list.add("1");
		System.out.println("Element adaugat cu succes!\n Program terminat.");
		list.delete(0);
		System.out.println("Element adaugat cu succes!\n Program terminat.");
		assertTrue("Functia <<vida>> nu este valida !",list.vida());
	}
	
}
