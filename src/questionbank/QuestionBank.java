package questionbank;
import java.util.ArrayList;
import java.util.Scanner;


public class QuestionBank {
	
	
		int questionId=1;
		String questionDescription;
		String academicYear;
		String concepts;

		public String toString(){
			return this.questionDescription+" \n "+this.academicYear+" \n "+this.concepts+" \n "+this.questionId;
		}
		public static void main(String[] args) {
			Scanner ip=new Scanner(System.in);
			QuestionBank q;
			ArrayList<QuestionBank> list=new ArrayList<>();
			

			System.out.println("Enter the number of questions you want stored in Question Bank:");
			int noOfQuestions=ip.nextInt();
			int questionId=1;
			while(questionId<=noOfQuestions ){
				System.out.println("--------------------------------------------------------");
				q=new QuestionBank();
				q.questionId=questionId++;
				System.out.println("Enter the question descrption:");
				ip.nextLine();
				q.questionDescription=ip.nextLine();
				System.out.println("Enter the academic year:");
				q.academicYear=ip.next();
				System.out.println("Enter the concept:");
				q.concepts=ip.next();

				list.add(q);
				System.out.println("--------------------------------------------------------");
				
			}
			
			System.out.println("--------------------------------------------------------");	
			System.out.println("Enter the year to fetch the questions:");
			String year=ip.next();
			retrieveQuestion(list, ""+year);
			System.out.println("--------------------------------------------------------");
			
			System.out.println(maxConcept(list));
			System.out.println("--------------------------------------------------------");
		}

		public static void retrieveQuestion(ArrayList<QuestionBank> list,String year){
			ArrayList<String> question=new ArrayList<>();
			for(int i=0;i<list.size();i++){
				if(list.get(i).academicYear.contains(year)){
					System.out.println(list.get(i).questionDescription);
				}
			}
			
		}

		public static String maxConcept(ArrayList<QuestionBank> list){
			int max=0;
			String maxRepeatedConcept=null;
			for(int i=0;i<list.size();i++){
				int count = 0;
				for(int j=0;j<list.size();j++){
					if(i!=j && list.get(i).concepts.equals(list.get(j).concepts)){
						count++;
					}
				}
				if(max<count){
					maxRepeatedConcept=list.get(i).concepts;
				}
			}
			return maxRepeatedConcept;
		}

}
