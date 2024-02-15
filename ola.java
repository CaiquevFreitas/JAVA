import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.time.LocalDateTime; 
public class Main{
	public static void main(String[] args) {
		String nome1 = "Caique";
		Locale brasil = new Locale("pt","BR");
		LocalDate hoje = LocalDate.now(); //Pega a data atual
		String diaDaSemana = hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, brasil); //Pega o dia da semana e coloca em português
		LocalDateTime agora = LocalDateTime.now(); //Pega a hora,minuto,segundo atual
		String saudacao = "";
		
		if (agora.getHour() >= 0 && agora.getHour() < 12){ //"getHour" Pega somente a hora
		    saudacao = "Bom dia";
		}
		else if (agora.getHour() >= 12 && agora.getHour() < 18){
		    saudacao = "Boa tarde";
		}
		else if (agora.getHour() >= 18 && agora.getHour() < 24){
		    saudacao = "Boa noite";
		}
		
		System.out.printf("Olá %s, hoje é %s. %s", nome1, diaDaSemana, saudacao);
	}
}
