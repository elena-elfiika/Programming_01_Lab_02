import java.util.Random;

public class Lab_02_Main{
	
	public static void main(String[] args){
      // задаем размерность матрицы
		int m=6, n=5;
      // создаем массив
		int arr[][] = new int [m][n];
      // заполняем
		arr = fill_arr(arr, m, n);
      // вывод
		print_mat(arr);
		print_mat(ed_arr(arr));
	}
   // заполнение массива случайными числами
	static int[][] fill_arr(int arr[][], int m, int n){
      // Заполняем массив данными
		Random r = new Random();
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++) {
				arr[i][j] = r.nextInt(199) - 99;
			}
		}
		
		return arr;
	}
   // вывод матрицы
	static void print_mat(int a[][]){ 
		// из массива строки
      for (int row[]:a){
         // из строки элементы							
			for (int kva : row) {
				System.out.printf("%4d",kva);
			}
			System.out.println();
		}
		System.out.println();
	}
   // нахождение максимального элемента матрицы
	static int find_max(int a[][], int id){
      // максимальный элемент в столбце по умолчанию
		int max = -99;
      // поиск нового максимального
		for (int i=0;i<a.length;i++){
			if(a[i][id] > max){
				max = a[i][id];
			}
		}
		return max;
	}
   // нахождение индекса
	static int[][] ed_arr(int a[][]){
		int tmp;
		int cut_pos = 0;
		int max = -99;
		for (int i=a[0].length-1;i>=0;i--){
			tmp = find_max(a,i);
			if(tmp >= max){
				max = tmp;
				cut_pos = i; 	
			}
		}
		return copy_cut(a,cut_pos);
	}
   // создание нового массива с удалением столбца
	static int[][] copy_cut(int a[][], int cut_pos){ 
		int m = a.length;
		int n = a[0].length - 1;
		int b[][] = new int [m][n];
		for (int i=0;i<m;i++){
			for (int k=0;k<cut_pos;k++){
				b[i][k] = a[i][k];
			}
			for (int k=cut_pos;k<n;k++){
				b[i][k] = a[i][k+1];
			}
		}
		return b;
	}
}