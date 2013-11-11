import static org.junit.Assert.*;

import org.junit.After;
//import org.junit.Test;


public class TestCD {
		CDList l=new CDList();
	@After
	public void tearDown() throws Exception {
		System.out.println("Test terminat !");
	}
	@org.junit.Test
	public void ReadFromFile() {
		l.ReadFromFile("Date.txt");
		assertTrue("Lista nu este vida !",l.getlength()==0);
	}
	@org.junit.Test
	public void WriteToFile() {
		CDList aux=new CDList();
		l.WriteToFile("Date.txt");
		aux.ReadFromFile("Date.txt");
		assertTrue("Lista nu este vida !",aux.getlength()==0);
	}
	@org.junit.Test
	public void AddCD() {
		CD nou=new CD();
		nou.nume="AAA";
		nou.tip="soft";
		nou.info="BBB";
		l.AddCD(nou);
		String m;
		m=l.getCD(l.getlength()-1).nume;
		assertTrue("Test1 esuat !",m.equals(nou.nume));
	}
	@org.junit.Test
	public void SearchCD() {
		CD nou=new CD();
		nou.nume="AAA";
		nou.tip="soft";
		nou.info="BBB";
		l.AddCD(nou);
		String m;
		m=l.SearchCD(nou).getCD(0).nume;
		assertTrue("Test2 esuat !",m.equals(nou.nume));
		
	}
	@org.junit.Test
	public void Sort() {
		CD nou=new CD();
		nou.nume="AAA";
		nou.tip="soft";
		nou.info="BBB";
		CD nou1=new CD();
		nou1.nume="BBB";
		nou1.tip="filme";
		nou1.info="AAA";
		l.AddCD(nou);
		l.AddCD(nou1);
		l.Sort(100);
		assertTrue("Test3 esuat !",l.getCD(0).nume.equals("AAA"));
		l.Sort(10);
		assertTrue("Test3 esuat !",l.getCD(0).nume.equals("BBB"));
		l.Sort(1);
		assertTrue("Test3 esuat !",l.getCD(0).nume.equals("BBB"));
		
	}
	@org.junit.Test
	public void sortname(){
		CD nou=new CD();
		nou.nume="AAA";
		nou.tip="soft";
		nou.info="BBB";
		CD nou1=new CD();
		nou1.nume="BBB";
		nou1.tip="filme";
		nou1.info="AAA";
		l.AddCD(nou);
		l.AddCD(nou1);
		l.sortname();
		assertTrue("Test4 esuat !",l.getCD(0).nume.equals("AAA"));
	}
	@org.junit.Test
	public void sorttip() {
		CD nou=new CD();
		nou.nume="AAA";
		nou.tip="soft";
		nou.info="BBB";
		CD nou1=new CD();
		nou1.nume="BBB";
		nou1.tip="filme";
		nou1.info="AAA";
		l.AddCD(nou);
		l.AddCD(nou1);
		l.sorttip();
		assertTrue("Test5 esuat !",l.getCD(0).nume.equals("BBB"));
	}
	@org.junit.Test
	public void sortinfo() {
		CD nou=new CD();
		nou.nume="AAA";
		nou.tip="soft";
		nou.info="BBB";
		CD nou1=new CD();
		nou1.nume="BBB";
		nou1.tip="filme";
		nou1.info="AAA";
		l.AddCD(nou);
		l.AddCD(nou1);
		l.sortinfo();
		assertTrue("Test6 esuat !",l.getCD(0).nume.equals("BBB"));
	}
	@org.junit.Test
	public void GetCD() {
		CD nou=new CD();
		nou.nume="AAA";
		nou.tip="soft";
		nou.info="BBB";
		l.AddCD(nou);
		String m;
		m=l.getCD(0).nume;
		assertTrue("Test7 esuat !",m.equals(nou.nume));
	}
	@org.junit.Test
	public void Creare() {
		assertNotNull("Lista este vida !",l);
	}
	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	@org.junit.Before
	public void setUp()throws Exception{
		System.out.println("Testul  a inceput !");
	}

}
