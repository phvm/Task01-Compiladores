import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class RPN {
    private Stack<Integer> pilha;

    public RPN(){
            pilha = new Stack<Integer>();
            }
    public static void main(String[] args) throws Exception{
        String expressao;
        int resultado;
        RPN avaliador = new RPN();
        expressao = "";
        //alterar o path para o do arquivo que possuir a expressao a ser analisada. 
        FileReader fr = new FileReader("C:\\Users\\user\\Desktop\\Testes\\Compiladores\\src\\Calc1.stk");
        BufferedReader lerArq = new BufferedReader(fr);
        String linha = lerArq.readLine();
        while (linha != null) {
            expressao += linha + " ";
            linha = lerArq.readLine(); //
          }
        resultado = avaliador.avaliar(expressao);
        System.out.println(resultado);
   }
	public int avaliar(String expr){
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

     private boolean isOperador(String token){
            return ( token.equals("+") || token.equals("-") ||
                     token.equals("*") || token.equals("/") || token.equals("%") );

        }
     private int avaliarOperador(char operacao, int op1, int op2){
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