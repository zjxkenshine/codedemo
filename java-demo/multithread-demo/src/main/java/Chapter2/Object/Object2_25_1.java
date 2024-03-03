package Chapter2.Object;

public class Object2_25_1 {
	//内置类	
	
	private String username;
	private String password;
	public class PrivateClass{         //Obj类与test类不在一个包，用public
		private String age;
		private String address;
		public String getAge(){
			return age;
		}
		public void setAge(String Age){
			this.age=Age;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void printA(){
			System.out.println(username+" "+password);
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
