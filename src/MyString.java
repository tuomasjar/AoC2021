
public class MyString {

	
	char[] data;
	public MyString(char[] data) {
		this.data = data;
	}
	
	public int length() {
		return data.length;
	}
	
	public char charAt(int index) {
		if(index < 0 || index > data.length-1)throw new IndexOutOfBoundsException("Index not Valid");
		return data[index];
	}
	
	public void reverse() {
		char[] reverse = new char[data.length];
		for(int i=0;i<data.length;i++) {
			reverse[i]=data[data.length-1-i];
		}
		this.data=reverse;
	}
	
	public boolean equals(MyString m) {
		if(this.data.length!=m.data.length)return false;
		for(int i=0;i<data.length;i++) {
			if(this.charAt(i)!=m.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean startsWith(MyString m) {
		if(m.data.length>this.data.length)return false;
		for(int i=0;i<m.data.length;i++) {
			if(m.data[i]!=this.data[i]) {
				return false;
			}
		}
		return true;
	}

}
