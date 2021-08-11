package algo_0329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_1755_숫자놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int a = Integer.parseInt(st.nextToken()); // 입력받은 첫번째 수
		int b = Integer.parseInt(st.nextToken()); // 입력받은 두번째 수
		int num[] = new int[b - a + 1]; // a ~ b까지의 모든 수를 넣을 배열
		String strArr[] = new String[b - a + 1]; // String 형식의 숫자가 들어갈 배열

		int temp = a; // num 배열에 a부터 넣기 위해 임시 변수 생성
		for (int i = 0; i < b - a + 1; i++) {
			num[i] = temp++; // num 배열에 숫자 입력

			String str; // num 배열의 각 숫자를 String으로 바꾼 변수
			if (num[i] / 10 == 0) // 만약 숫자가 10보다 작다면 한번만 수행
				str = makeStr(num[i]); // 숫자를 String으로 바꾸는 메소드를 실행한 결과를 str에 저장
			else { // 만약 숫자가 10보다 크거나 같다면 10의 자리 숫자와 1의 자리 숫자를 나눠서 수행
				int mok = num[i] / 10; // 10의 자리 숫자
				int nam = num[i] % 10; // 1의 자리 숫자
				str = makeStr(mok) + " " + makeStr(nam); // 각 숫자를 String으로 바꾸고 저장
			}
			strArr[i] = str; // String으로 변환한 숫자를 strArr배열에 담는다.
		}

		Arrays.sort(strArr); // 사전 순으로 정렬
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int i = 0; i < strArr.length; i++) {
			String[] temp2 = new String[2]; // strArr에 담겨있는 string을 공백을 기준으로 나눠 담을 배열
			temp2 = strArr[i].split(" "); // 공백을 기준으로 나눠 담는다.

			for(int j = 0; j < temp2.length; j++) { // temp2에 담긴 단어의 개수만큼 반복
				sb.append(makeNum(temp2[j])); // String 숫자를 int로 바꿔 StringBuilder에 추가
			}
			cnt++;
			if(cnt % 10 == 0)
				sb.append("\n"); //StringBuilder에 공백 추가
			else
				sb.append(" ");
		}
		System.out.println(sb); //출력
	}

	// String 형식의 숫자를 int 형식의 숫자로 변환하는 메소드
	private static int makeNum(String string) {
		int result = 0;
		switch (string) {
		case "zero":
			result = 0;
			break;
		case "one":
			result = 1;
			break;
		case "two":
			result = 2;
			break;
		case "three":
			result = 3;
			break;
		case "four":
			result = 4;
			break;
		case "five":
			result = 5;
			break;
		case "six":
			result = 6;
			break;
		case "seven":
			result = 7;
			break;
		case "eight":
			result = 8;
			break;
		case "nine":
			result = 9;
			break;
		}

		return result;
	}

	// int 형식의 숫자를 String 형식의 숫자로 변환하는 메소드
	private static String makeStr(int i) {
		String result = null;
		switch (i) {
		case 0:
			result = "zero";
			break;
		case 1:
			result = "one";
			break;
		case 2:
			result = "two";
			break;
		case 3:
			result = "three";
			break;
		case 4:
			result = "four";
			break;
		case 5:
			result = "five";
			break;
		case 6:
			result = "six";
			break;
		case 7:
			result = "seven";
			break;
		case 8:
			result = "eight";
			break;
		case 9:
			result = "nine";
			break;
		}

		return result;
	}

}
