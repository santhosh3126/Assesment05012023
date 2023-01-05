import java.util.*;
import java.io.*;
class Book implements Serializable{
    String autName;
	String bookName;
	int isbcNo;
	Book(String autName,String bookName,int isbcNo){
	    this.autName = autName;
		this.bookName = bookName;
		this.isbcNo = isbcNo;
	}
	public String toString(){
	    return " Author Name : "+autName+" Book Name : "+bookName+ " ISBC No : "+isbcNo;
	}
}
class MainCol{
    public static void main(String...args)throws IOException,ClassNotFoundException{
	    HashSet<Book> hs = new HashSet<Book>();
		Book b1 = new Book("Kalki","Ponniyin Selvan",12345);
		Book b2 = new Book("Valluvar","Thirukural",56789);
        hs.add(b1);
		hs.add(b2);
            
			FileOutputStream fos = new FileOutputStream("D:\\SANTHOSH\\Java Programs\\book\\santhosh.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(hs);
			oos.close();
			fos.close();
			FileInputStream fis = new FileInputStream("D:\\SANTHOSH\\Java Programs\\book\\santhosh.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashSet<Book> hs1 =(HashSet<Book>)ois.readObject();
			ois.close();
			fis.close();
			for(Book bks:hs1){
				System.out.println(bks);
			}
			HashSet<Book> hs2 =(HashSet<Book>)hs1.clone();
			Iterator it = hs2.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
	}
}