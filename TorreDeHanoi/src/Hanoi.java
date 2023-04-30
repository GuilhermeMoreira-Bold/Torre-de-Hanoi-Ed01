public class Hanoi {
    long movimentos = 0;
    public long hanoiTower(int n, char origem, char destino, char auxiliar){
        if(n>0){
            hanoiTower(n -1, origem, destino, auxiliar);
            this.movimentos += 1;
            hanoiTower(n -1, origem, destino, auxiliar);
        }

        return movimentos;
    }
}
