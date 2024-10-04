import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        NumberFormat nfDolar = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat nfReal = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        NumberFormat nfArg = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));
        NumberFormat nfCol = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        ObterCotacao cotacao = new ObterCotacao();
        Moedas novaCotacao = cotacao.obtendoCotacao();

        int  opcao = 0;
        try {

            while (opcao != 7) {
                System.out.println("""
                        
                        *******************************************************************
                        Seja bem-vindo/a ao Conversor de Moeda =]
                        
                        1) Dólar =>> Peso Argentino
                        2) Peso Argentino =>> Dólar
                        3) Dólar =>> Real Brasileiro
                        4) Real Brasileiro =>> Dólar
                        5) Dólar =>> Peso Colombiano
                        6) Peso Colombiano =>> Dólar
                        7) Sair
                        Escolha uma opção válida:
                        *******************************************************************
                        """);
                opcao = leitura.nextInt();
                double dolar = 0;
                double real = 0;

                switch (opcao) {
                    case 1:
                        System.out.println("Digite o valor que deseja converter:");
                        dolar = leitura.nextDouble();
                        double conversaoDolar = dolar * Double.valueOf(novaCotacao.conversion_rates().ARS());
                        System.out.println("Valor " + nfDolar.format(dolar) + " [USD] corresponde ao valor final de " + nfArg.format(conversaoDolar) + " [ARS]");
                        System.out.println("Última atualização da cotação: " +novaCotacao.time_last_update_utc().substring(0, novaCotacao.time_last_update_utc().length()-6));
                        break;
                    case 2:
                        System.out.println("Digite o valor que deseja converter:");
                        double pesoArg = leitura.nextDouble();
                        double conversaoPesoArg = pesoArg / Double.valueOf(novaCotacao.conversion_rates().ARS());
                        System.out.println("Valor " + nfArg.format(pesoArg) + " [ARS] corresponde ao valor final de " + nfDolar.format(conversaoPesoArg) + " [USD]");
                        System.out.println("Última atualização da cotação: " +novaCotacao.time_last_update_utc().substring(0, novaCotacao.time_last_update_utc().length()-6));
                        break;
                    case 3:
                        System.out.println("Digite o valor que deseja converter:");
                        dolar = leitura.nextDouble();
                        double conversaoReal = dolar * Double.valueOf(novaCotacao.conversion_rates().BRL());
                        System.out.println("Valor " + nfDolar.format(dolar) + " [USD] corresponde ao valor final de " + nfReal.format(conversaoReal) + " [BRL]");
                        System.out.println("Última atualização da cotação: " +novaCotacao.time_last_update_utc().substring(0, novaCotacao.time_last_update_utc().length()-6));
                        break;
                    case 4:
                        System.out.println("Digite o valor que deseja converter:");
                        real = leitura.nextDouble();
                        double conversaoRealDolar = real / Double.valueOf(novaCotacao.conversion_rates().BRL());
                        System.out.println("Valor " + nfReal.format(real) + " [BRL] corresponde ao valor final de " + nfDolar.format(conversaoRealDolar) + " [USD]");
                        System.out.println("Última atualização da cotação: " +novaCotacao.time_last_update_utc().substring(0, novaCotacao.time_last_update_utc().length()-6));
                        break;
                    case 5:
                        System.out.println("Digite o valor que deseja converter:");
                        dolar = leitura.nextDouble();
                        double conversaoDolarPesoCol = dolar * Double.valueOf(novaCotacao.conversion_rates().COP());
                        System.out.println("Valor " + nfDolar.format(dolar) + " [USD] corresponde ao valor final de " + nfCol.format(conversaoDolarPesoCol) + " [COP]");
                        System.out.println("Última atualização da cotação: " +novaCotacao.time_last_update_utc().substring(0, novaCotacao.time_last_update_utc().length()-6));
                        break;
                    case 6:
                        System.out.println("Digite o valor que deseja converter:");
                        double pesoCol = leitura.nextDouble();
                        double conversaoPesoColDolar = pesoCol / Double.valueOf(novaCotacao.conversion_rates().COP());
                        System.out.println("Valor " + nfCol.format(pesoCol) + " [COP] corresponde ao valor final de " + nfDolar.format(conversaoPesoColDolar) + " [USD]");
                        System.out.println("Última atualização da cotação: " +novaCotacao.time_last_update_utc().substring(0, novaCotacao.time_last_update_utc().length()-6));
                        break;
                    case 7:
                        System.out.println("Finalizando o programa...");
                        break;
                    default:
                        System.out.println("Você digitou uma opção inválida! As opções são de 1 a 7.");
                        break;
                }
            }

        }catch (InputMismatchException e){
             System.out.println("Erro ao digitar uma opçao! As opções são numéricas.");
        }


    }
}