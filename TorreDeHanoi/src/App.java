import javax.swing.JOptionPane;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        
        int numeroDeDiscos = Integer.parseInt(JOptionPane.showInputDialog("Digite quantos discos serão movidos"));
        char origem = 'A';
        char destino = 'B';
        char auxiliar = 'C';
        ArrayList<Integer> frequenciaLista = new ArrayList<Integer>();
        Hanoi hanoi = new Hanoi();
        long quantidadeMovimentos = (long)( Math.pow(2, numeroDeDiscos) -1);
        System.out.println("Quantidade de movimentos estimado: " + quantidadeMovimentos);

        OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double freq = Math.round(bean.getProcessCpuTime() /1000000.0/60 * Math.pow(10, 2)) / Math.pow(10, 2);
        
        Thread thread = new Thread();
        int i = 0;
        // while(i < 10000){
        //     double currentFreq = Math.round(bean.getProcessCpuTime() /1000000.0/60 * Math.pow(10, 2)) / Math.pow(10, 2);

        //     if(currentFreq > 0.1 && currentFreq <= 3.11){
        //         frequenciaLista.add((int)(Math.round(bean.getProcessCpuTime() /1000000.0/60 * Math.pow(10, 2)) / Math.pow(10, 2)));
        //         i++;
        //         thread.sleep(1);
        //     }
        // }
        double media = 0;
        for(int k = 0; k < frequenciaLista.size(); k++){
            media += frequenciaLista.get(k);
        }
        freq = media / frequenciaLista.size();
        System.out.println("Frequencia media: "+freq+"GHz");


        long millis = ((long)((quantidadeMovimentos/3.11)/1000/60/3.11));
        long horas = (long)millis/(60*60*1000);
        millis %=(60*60*1000);
        long minutos = (long)millis/(60*1000);
        millis %= (60*1000);
        long segundos = (long)millis/1000;
        millis %= 1000;
        String tempoEstimado = new String(String.format("%0"+2+"d",horas)+":"+String.format("%0"+2+"d",minutos)+":"+ String.format("%0" + 2 +"d", segundos)+":"+ String.format("%0" + 3 +"d", millis));
        System.out.println("Tempo estimado: " + tempoEstimado);


        long comeco = System.currentTimeMillis();
        System.out.println("Número de movimentos total: "+ hanoi.hanoiTower(numeroDeDiscos, origem, destino, auxiliar));
        long fim = System.currentTimeMillis();
        millis = fim - comeco;
        horas = (int)millis/(60*60*1000);
        millis %=(60*60*1000);
        minutos = (int)millis/(60*1000);
        millis %= (60*1000);
        segundos = (int)millis/1000;
        millis %= 1000;
        String tempo = new String(String.format("%0"+2+"d",horas)+":"+String.format("%0"+2+"d",minutos)+":"+ String.format("%0" + 2 +"d", segundos)+":"+ String.format("%0" + 3 +"d", millis));
        System.out.println("DeltaTime: " + tempo);
    }

}
