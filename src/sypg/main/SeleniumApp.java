package sypg.main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumApp {
	public static void main(String[] args) {
		Path path = Paths.get(System.getProperty("user.dir"), "src/resources/chromedriver.exe");
		
		/* WebDriver 경로 설정 */
		System.setProperty("webdirver.chrome.driver", path.toString());
		System.out.println(System.getProperty("webdirver.chrome.driver"));
		
		/* WebDriver 옵션 설정 */
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--start-maximized"); // 전체화면으로 실행
		chromeOptions.addArguments("--disabled-popup-blocking"); // 팝업 무시
		chromeOptions.addArguments("--disable-default-apps"); // 기본앱 사용 안함
		//chromeOptions.addArguments("headless"); // 창을 띄우지 않고 작업
		
		
		
		
		/* WebDriver 객체 생성 */
		ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
		
		/* 빈 탭 생성 */
		//chromeDriver.executeScript("window.open('about:blank', '_blank');");
		
		/* 탭 목록 가져오기 */
//		List<String> tabs = new ArrayList<String>(chromeDriver.getWindowHandles());
//		for ( String tab : tabs ) {
//			System.out.println(tab);
//		}
		
		/* 첫번째 탭으로 전환 */
//		chromeDriver.switchTo().window(tabs.get(0));
		/* URL로 이동 */
		//chromeDriver.get("https://www.naver.com/"); // 네이버
		//chromeDriver.get("https://selenium.dev");
		//chromeDriver.get("https://www.naver.com/");
		//chromeDriver.navigate().to("https://selenium.dev");
		chromeDriver.navigate().to("https://fow.kr/robots.txt");
		
		/* 뒤로 가기 버튼 클릭*/
		//chromeDriver.navigate().back();
		
		/* 앞으로 가기 버튼 클릭*/
		//chromeDriver.navigate().forward();
		
		/* 새로고침 */
		//chromeDriver.navigate().refresh();
		
		/* 추출 */
			/* get */
//				System.out.println(chromeDriver.getTitle()); // String : title
//				System.out.println(chromeDriver.getCurrentUrl()); // String : url
//				System.out.println(chromeDriver.getPageSource()); // String : page 전부(태그, ...)
//				System.out.println(chromeDriver.getSessionStorage());
//				System.out.println(chromeDriver.getLocalStorage());
//				System.out.println(chromeDriver.getWindowHandle());
			/* find */
				//System.out.println(chromeDriver.findElement(By.id("selenium_grid")).getAttribute("xmlns") );
//				for ( WebElement webElement : chromeDriver.findElements(By.cssSelector(".selenium-logo svg")) ) {
//					System.out.println(webElement.getAttribute("id"));
//				}
		
		
		for ( String line : Arrays.asList(chromeDriver.getPageSource().split("\n")) ) {
			System.out.println(line);
		}
		
						
		/* chromeDriver 종료 */
		//chromeDriver.quit();
		
		//List<WebElement> imgElement = chromeDriver.findElements(By.cssSelector("img"));
		
		/* */
		
		
		
		
	}
}

