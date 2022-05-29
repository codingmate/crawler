package sypg.main;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingApp {
	
	private static String URL = "https://www.op.gg/multisearch/kr?";
	private static String ID = "한상영";
	private static List<String> searchIdList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		// 0. parameter setting
		searchIdList.add("한상영");
		searchIdList.add("팀 운은 없다");
		searchIdList.add("강슬기님팬");
		searchIdList.add("혼자하는ID");
		searchIdList.add("eppqooq");
		searchIdList.add("윤제씌");
		searchIdList.add("현민강");
		searchIdList.add("AaBaTa");
		searchIdList.add("xin shou baizuan");
		
		
		// 1. Document를 가져옴
		Document doc = Jsoup.connect(URL + getParameter()).get();
		System.out.println(URL + getParameter());
		System.out.println("---------------------------------");
		
		// 2. 페이지 전체를 가져옴
		//System.out.println(doc.toString());
		
		// 3. 목록을 골라서 가져와봄
		Elements list = doc.select(".content ul");
		
		// 4. 목록에서 원하는 걸 가져와봄
		int row = 0;
		for ( Element element : list ) {
			
			System.out.println("row : " + ++row + ", " + element);
			System.out.println("---------------------------------");
		}
		
	}
	
	
	/**
	 * ALT+SHIFT+J
	 * URL 완성
	 * @param keyword
	 * @return
	 */
	public static String getParameter() {
		StringBuilder parameter = new StringBuilder();
		parameter.append("summoners=");
		for ( String id : searchIdList ) {
			parameter.append(id.concat(","));
		}
		
		return parameter.toString();
	}
	
	//https://www.op.gg/multisearch/kr?summoners=%ED%95%9C%EC%83%81%EC%98%81%2C%EA%B0%95%EC%8A%AC%EA%B8%B0%EB%8B%98%ED%8C%AC
}

