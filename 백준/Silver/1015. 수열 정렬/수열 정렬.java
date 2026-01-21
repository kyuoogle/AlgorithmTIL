import java.util.Arrays;
import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[][] = new int[2][N]; //2행 N열 배열
		for(int i = 0; i < arr[0].length; ++i)
		{
			arr[0][i] = sc.nextInt(); //0행 입력받음
			arr[1][i] = arr[0][i]; //1행의 값들은 0행의 값들과 같게함
		}
		Arrays.sort(arr[1]); //1행의 값들을 정렬시킴
		for(int i = 0; i < N; ++i)//기존 배열과 정렬된 배열의 값이 같은 인덱스를 찾음
		{
			for(int j = 0; j < N; ++j)
			{
				if(arr[0][i] == arr[1][j])//기존 배열과 정렬된 배열의 값이 같다면
				{
					System.out.print(j + " ");//인덱스를 출력함
					arr[1][j] = -1;//중복 인덱스 출력을 방지하기 위해 -1로 바꿈
					break;
				}
			}
		}
	}
}