package programers.level2;

public class 일이사의나라 {
    
        public static String answer = "";
        
        public void devideByThree(int n) {
    
            //3진수 => 0,1,2
            //3으로 나누어 떨어질 때
            //자릿수를 하나 안올리고 4로 박아야함
            
            int quotient = n / 3;  
            int remainder = n % 3;
    
            String addValue = "";
            
            if(remainder == 0){
                addValue = "4";
                quotient -= 1;
            } else {
                addValue = String.valueOf(remainder);
            }
            
            answer = addValue + answer;
            
            if(quotient < 1){
               return;
            }
    
            
            devideByThree(quotient);
            
        }    
        public String solution(int n) {
            devideByThree(n);
            return answer;
        }
        

}
