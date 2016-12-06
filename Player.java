import java.util.ArrayList;

class Player {
		private String name;
	private int chips;
	private int bet=0;
	private ArrayList<Card> oneRoundCard;
	public Player(String name, int chips){
		this.name=name;
		this.chips=chips;
	}
	public String get_name(){
		return name;
	}
	public int make_bet(){
		bet=1;
		if (chips<=0){
			bet=0;
		}
		return bet;
	}
	public void setOneRoundCard(ArrayList<Card> cards){
		oneRoundCard=cards;
	}
	public boolean hit_me(){
		boolean hit=false;
		if(getTotalValue()<=16){
			hit=true;
		}
		if(getTotalValue()>=17){
			hit=false;
		}
		return hit;
	
	}
	public int getTotalValue(){
		int sum=0;
		for(Card card:oneRoundCard){
			if(card.getRank()>=2&&card.getRank()<=10){
				sum+=card.getRank();
			}
			else if(card.getRank()>=11&&card.getRank()<=13){
				sum+=10;
			}
			else if(card.getRank()==1){
				sum+=1;
				if(sum<=11){
					sum+=10;
				}
			}
		}
	return sum;
	}
	public int get_current_chips(){
		return chips;
		
	}
	public void increase_chips (int difference){
		chips+=difference;
	}
	public void say_hello(){
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");

	}
}

