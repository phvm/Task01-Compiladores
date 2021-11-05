import java.util.Scanner;
import java.util.Stack;

public class RPN {
    private Stack<Integer> pilha;

    public RPN(){
            pilha = new Stack<Integer>();
            }
    public static void main(String[] args){
            String expressao;
            int resultado;

            Scanner teclado = new Scanner(System.in);

            RPN avaliador = new RPN();
            expressao = teclado.nextLine();

            resultado = avaliador.avaliar(expressao);
            System.out.println(resultado);
       }

    public int avaliar(String expr) 
        {
            int op1, op2, resultado = 0;
            String token;
            Scanner in = new Scanner(expr);

            while (in.hasNext())        
            {
                token = in.next();          

                if (isOperador(token))
                {
                    op2 = (pilha.pop()).intValue();
                    op1 = (pilha.pop()).intValue();
                    resultado = avaliarOperador(token.charAt(0), op1, op2);     //
                    pilha.push(resultado);
                }
                else
                	pilha.push(Integer.parseInt(token));       
            }

            return resultado;
        }

     private boolean isOperador(String token)
        {
            return ( token.equals("+") || token.equals("-") ||
                     token.equals("*") || token.equals("/") || token.equals("%") );

        }
     private int avaliarOperador(char operacao, int op1, int op2)
        {
            int resultado = 0;

            switch (operacao)
            {
                case '+':
                    resultado = op1 + op2;
                    break;
                case '-':
                    resultado = op1 - op2;
                    break;
                case '*':
                    resultado = op1 * op2;
                    break;
                case '/':
                    resultado = op1 / op2;
                    break;
                case '%':
                    resultado = op1 % op2;
                    break;
            }
            return resultado;
        }
}