package iedu.data;

public class LoginData {
	//	1.	�Ѿ���� �����͸� ����� ������ �����Ѵ�.
	String		id;
	String		pass;
	int			age;		//	�Ѿ���� �������� ���¿� �°� ���� �� �ִ�.
	String		phone1, phone2, phone3;
	//	���� �̸��� Ű���� ������ ������ �迭�� ó���ؼ� ���� ���� �ִ�.
	String[]	hobby;
	
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	//	������ ����� �� �ִ� ������ �����ͷ� �ִ� �Լ��� ������.
	public String getHobbyStr() {
		String temp = "";
		for(int i = 0; i < hobby.length; i++) {
			temp += hobby[i] + " ";
		}
		return temp;
	}

	
	//	2.	get, set �Լ��� �����Ѵ�.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		//	���࿡ �ʿ��ϴٸ� �� �κп��� ���Ἲ �˻縦 �����ϵ��� �Ѵ�.
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		//	��ó�� �߰� �ܰ迡�� ���Ἲ �˻縦 �ؼ� ���� �� �� �ִ�.
		if(age < 0) {
			this.age = 0;
		}
		else {
			this.age = age;
		}
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	
	//	�������� ����� �� �ִ� ���� ������ �����͸� �����ϵ��� get �Լ��� �߰��� �� �ִ�.
	public String getPhone() {
		//	���� �������� ��ȭ��ȣ�� ��� ������ �ְڴ�.
		return phone1 + "-" + phone2 + "-" + phone3;
	}
	//	�� �۾��� ���� ��� ��¥�� ���ϴ� ����� ���� ������ �����ִ�.
	//		SimpleDataFormat Ŭ������ �̿��ؼ�......
}