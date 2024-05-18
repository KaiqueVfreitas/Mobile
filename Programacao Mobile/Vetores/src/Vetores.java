
public class Vetores {

	public Vetores() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex2Medias();
	}

	private static void ex2Medias() {
		double maior = 0;
		double medias[] = {7.4, 8.1, 9, 4, 3.2};
		int i = 0;
		while (i < medias.length); {
			if(medias[i] > maior) {
				maior = medias[i];
			}
			i++;
		}
		System.out.println(maior);
   
    }


	private static void ex1Nomes() {
		// TODO Auto-generated method stub
		String [] nomes = new String [25];
		nomes [0] = "Ana";
		nomes [1] = "João";
		nomes [2] = "Rebecca";
		nomes [3] = "Guilherme";
		nomes [4] = "Kaique";
		nomes [5] = "Carolina";
		nomes [6] = "Pedro";
		nomes [7] = "Mariana";
		nomes [8] = "Lucas";
		nomes [9] = "Isabela";
		nomes [10] = "Rafael";
		nomes [11] = "Camila";
		nomes [12] = "Gabriel";
		nomes [13] = "Larissa";
		nomes [14] = "Felipe";
		nomes [15] = "Juliana";
		nomes [16] = "Matheus";
		nomes [17] = "Natália";
		nomes [18] = "Fernando";
		nomes [19] = "Beatriz";
		nomes [20] = "Thiago";
		nomes [21] = "Débora";
		nomes [22] = "Vinícius";
		nomes [23] = "Amanda";
		nomes [24] = "Diego";

		int repetidor = 0;
		
		while(repetidor < nomes.length) {
			System.out.println(nomes[repetidor]);
			repetidor ++;
		}
	}

}
