package domain;
/*class Val<T>{
	T e;
}
*/
import interfaces.ILista;

import java.lang.reflect.Array;
import java.io.*;
//public 
public class Lista<T> implements ILista<T>,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T[] val;
	private int length;
	private int prec[];
	private int next[];
	private int primliber;
	private int maxlength;
	private int prim;
	@SuppressWarnings("unchecked")
	
	public Lista(Class <T> tip){
		val= (T[])Array.newInstance(tip, 10);
		length=0;
		primliber=0;
		maxlength=50;
		prim=0;
		prec=new int [50];
		next=new int [50];
	}
	
//	private class Iterator{
		
		
//	}
		/*for(int i=0;i<50;i++)
			val[i] = new Val<T>();*/
		/*for(int i=0;i<50;i++)
			val[i]=(T)new String();
		//val[50]={0};*/
	
	/* (non-Javadoc)
	 * @see ILista#add(java.lang.T)
	 */
	@Override
	public void add(T i) {
		// TODO Auto-generated method stub
		int j=0,k;
		//System.out.println("Max="+maxlength+"\n"+length);
		//System.out.println("1\n");
		if(length==0){
			primliber=0;
			prec[primliber]=-1;
			prim=primliber;
		}
		else{
			//System.out.println("aaaaa"+next[j]+"      "+maxlength);
			while(j<maxlength){
				if(next[j]==primliber){
					prec[primliber]=j;
					//System.out.println("bb"+next[j]+"      ");
					j=maxlength;
					
				}
				else
					j++;
				//System.out.println(j+"\n");
			}
			//System.out.println("3\n");
		}
		j=0;
		val[primliber]=i;
		//System.out.println("Mamaliga"+val[primliber]+"\n");
		k=primliber;
		while(j<maxlength){
			if(val[j]==null){
				primliber=j;
				j=maxlength;}
			else
				j++;
			
			//if(j==maxlength&&primliber==k)
			//	maxlength=maxlength*2;
			}
		//System.out.println("4");
		next[k]=primliber;
		prec[primliber]=k;
		System.out.println("Elementul "+i+" a fost adaugat cu succes!\n");
		//System.out.print(' ');
		//System.out.println("AL"+next[0]+next[1]+next[2]);
		length++;
		//System.out.println("bzzz "+length+'\n');
		}


	/* (non-Javadoc)
	 * @see ILista#element(int)
	 */
	@Override
	public T element(int i) {
		// TODO Auto-generated method stub
		int j,k;
		k=prim;
		//try
		for(j=0;j<i;j++)
				k=next[k];
		return val[k];
				//catch
	}

	/* (non-Javadoc)
	 * @see ILista#delete(int)
	 */
	@Override
	public void delete(int i) {
		// TODO Auto-generated method stub
		//System.out.println("AL"+next[0]+next[1]+next[2]);
		int j,k,l;
		T m;
		k=prim;
		l=k;
		//System.out.println("bla"+length+"\n");
		if(i==0){
			m=val[k];
			//System.out.println(prim+"m="+m+" - "+k+"\n");
			prec[next[k]]=-1;
			prim=next[k];
		}
		else{
			for(j=0;j<i;j++){
				l=k;
				k=next[k];
			}
			//System.out.println("bla\n");
			m=val[k];
			//System.out.println(" Next[k]="+k+"  "+prim+"m="+m+" - "+k+"\n");
			next[l]=next[k];
			prec[next[k]]=l;}
		System.out.print("A fost sters al "+i+" -lea element avand valoarea "+m+'\n');
		length--;
	}
	
	/* (non-Javadoc)
	 * @see ILista#size()
	 */
	@Override
	public int size() {
		return length;
	}
	
	/* (non-Javadoc)
	 * @see ILista#vida()
	 */
	@Override
	public boolean vida() {
		return (size()==0);
	}
	/* (non-Javadoc)
	 * @see ILista#get_urm(int)
	 */
	@Override
	public int get_urm(int i){
		return next[i];
	}
	/* (non-Javadoc)
	 * @see ILista#get_prim()
	 */
	@Override
	public int get_prim(){
		return prim;
	}
}
