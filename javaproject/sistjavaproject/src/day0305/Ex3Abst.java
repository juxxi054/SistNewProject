package day0305;


//추상메서드 하나라도 가지고 있다면 추상클래스
abstract class Game{
	abstract void play (); //추상메서드
	abstract void stop();
	
}

class ain extends Game {

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("아인님이 게임을 시작합니다");
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("아인님이 게임을 중단합니다");
	}
}
	
class juhee extends Game{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("주희님이 게임을 시작합니다");
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("주희님이 게임을 중단합니다");
		
	}
	
}
	
class heyin extends Game {

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("혜인님이 게임을 시작합니다");
	}

	@Override
	void stop() {
		// TODO Auto-generated method stub
		System.out.println("혜인님이 게임을 중단합니다");
	}
	}



public class Ex3Abst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//배열선언 3개
		Game[] game=new Game[3]; //부모로 선언
        
		//각각의 자식으로 생성
		game[0]=new ain();
		game[1]=new juhee();
		game[2]=new heyin();
				
		
		//출력
		for(int i=0;i<game.length;i++)
		{
			game[i].play();
		}
		System.out.println("===========");
		for(int i=game.length-1;i>=0;i--)
		{
			game[i].stop();
		}
	}


}



