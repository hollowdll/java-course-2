package practice;

class Main implements InterfacePractice {
	
	public int calculate(int x, int y) {
		return x + y;
	}

	public static void main(String[] args) {
		
		for (EnumPractice value : EnumPractice.values()) {
			System.out.println(value);
		}
		
		EnumPractice value = EnumPractice.TUE;
		
		switch (value) {
		case MON:
			break;
			
		case TUE:
			System.out.println("Value is: " + value);
			break;
			
		case WED:
			break;
			
		case THU:
			break;
			
		case FRI:
			break;
			
		default:
			System.exit(0);
		}
		
	}

}
