package Count;

class Shared{
	public  synchronized String  PrintWc(char c,String p) {
		String s=p+c;
		if (Character.isUpperCase(c)) {
			for(char i='A';i<=c;i++) {
				try {
					Thread.sleep(300);
				}catch(Exception e) {
					
				}
				System.out.println(p+i);
			}
		}
		
		if (Character.isLowerCase(c)) {
			for(char i='a';i<=c;i++) {
				try {
					Thread.sleep(300);
				}catch(Exception e) {
					
				}
				System.out.println(p+i);
			}
		}
			
			return s;
			
		}
		
		

}

class Words{
	private Shared s;
	Words(Shared s){
		this.s=s;
	}
	void PrintS() {
		String p="",Sentence="Hello World";
		for(char i:  Sentence.toCharArray()) {
			if(i=='c') {
				p=p+i;
			}else {
				p=s.PrintWc(i,p);
			}
		}
	}
	
}

public class StringAnimator {
	public static void main(String[] args) {
		Shared s=new Shared();
		Words w=new Words(s);
		Thread t=new Thread(()->w.PrintS());
		t.start();
	}

}
