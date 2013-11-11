class CD{
	public String nume=new String();
	public String tip=new String();
	public String info=new String();
};
public class CDList {
	private CD date[];
	private int length;
	public CDList(){
		date=new CD[100];
		for(int i=0;i<99;i++)
			date[i]=new CD();
		
		length=0;
	}
	public void ReadFromFile(String txt){
		String[] m;
		Fisier f=new Fisier();
		f.CitireFisier(txt);
		//System.out.println(f.length);
		try{
		for(int i=0;i<f.length;i++){
			m=f.array[i].split("@");
			//System.out.println(m[0]);
			date[i].nume=m[0];
			//System.out.println(m[0]);
			date[i].tip=m[1];
			date[i].info=m[2];
			length++;
			}
		}catch(Exception e){
			System.out.println("Fisier invalid!");
			f.ScriereFisier(txt);
		}
	}
	public void WriteToFile(String txt){
		Fisier f=new Fisier();
		int i;
		for(i=0;i<length;i++)
			f.array[i]=date[i].nume+"@"+date[i].tip+"@"+date[i].info;
		f.ScriereFisier(txt);
	}
	public void AddCD(CD nou){
		date[length]=nou;
		length++;
	}
	public CDList SearchCD(CD nou){
		CDList rez=new CDList();
		for(int i=0;i<length;i++)
			if(date[i].info.contains(nou.info)&&date[i].nume.contains(nou.nume)&&date[i].tip.contains(nou.tip))
				rez.AddCD(date[i]);
		return rez; 
	}
	public void Sort(int i){
		if(i%10==1)
			sortinfo();
		if(i%100==10||i%100==11)
			sorttip();
		if(i>=100)
			sortname();
		
		
	}
	public void sortname(){
		CD aux=new CD();
		int k=0;
		while(k<length){
			for(int j=0;j<length;j++)
				if(date[k].nume.compareTo(date[j].nume)<0){
						aux=date[k];
						date[k]=date[j];
						date[j]=aux;
						}
		k++;}
	
	}
	public void sorttip(){
		CD aux=new CD();
		int k=0;
		while(k<length){
			for(int j=0;j<length;j++)
				if(date[k].tip.compareTo(date[j].tip)<0){
						aux=date[k];
						date[k]=date[j];
						date[j]=aux;
						}
		k++;}
	
	}
	public void sortinfo(){
		CD aux=new CD();
		int k=0;
		while(k<length){
			for(int j=0;j<length;j++)
				if(date[k].info.compareTo(date[j].info)<0){
						aux=date[k];
						date[k]=date[j];
						date[j]=aux;
						}
		k++;}
	
	}
		
	public int getlength(){
		return length;
	}
	
	public CD getCD(int i){
		return date[i];
	}
	
}