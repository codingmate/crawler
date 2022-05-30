package sypg.main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;


public class SeleniumApp {
	public static void main(String[] args) throws Exception{
		Path path = Paths.get(System.getProperty("user.dir"), "src\\resources\\chromedriver.exe");
		
		/* WebDriver 경로 설정 */
		System.setProperty("webdirver.chrome.driver", path.toString());
		System.out.println(System.getProperty("webdirver.chrome.driver"));
		
		/* WebDriver 옵션 설정 */
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized"); // 전체화면으로 실행
		chromeOptions.addArguments("--disabled-popup-blocking"); // 팝업 무시
		chromeOptions.addArguments("--disable-default-apps"); // 기본앱 사용 안함
		//chromeOptions.addArguments("headless"); // 창을 띄우지 않고 작업
		Properties prop = new Properties();
		prop.load(new FileInputStream("src\\sypg\\resources\\properties\\config.properties"));
		System.out.println(prop.getProperty("id"));
		
		
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
		//chromeDriver.navigate().to("https://selenium.dev");
		//chromeDriver.navigate().to("https://fow.kr/robots.txt");
		Thread.sleep(1000);
		chromeDriver.get("https://nid.naver.com/");
		Thread.sleep(1000);
		
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		
		StringSelection id = new StringSelection(prop.getProperty("id"));
		StringSelection pw = new StringSelection(prop.getProperty("pw"));
		chromeDriver.findElement(By.name("id")).click();
		Thread.sleep(1000);
		clipboard.setContents(id, null);
		chromeDriver.findElement(By.name("id")).sendKeys(Keys.CONTROL, "v");
		Thread.sleep(1000);
		chromeDriver.findElement(By.name("pw")).click();
		clipboard.setContents(pw, null);
		chromeDriver.findElement(By.name("pw")).sendKeys(Keys.CONTROL, "v");
		Thread.sleep(1000);
		chromeDriver.findElement(By.name("pw")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		chromeDriver.get("https://new.land.naver.com/complexes");
		chromeDriver.executeScript("window.open('about:blank', '_blank');");
		Thread.sleep(500);
		List<String> tabs = new ArrayList<String>(chromeDriver.getWindowHandles());
		chromeDriver.switchTo().window(tabs.get(1));
		chromeDriver.get("https://new.land.naver.com/houses");
		chromeDriver.executeScript("window.open('about:blank', '_blank');");
		Thread.sleep(500);
		tabs = new ArrayList<String>(chromeDriver.getWindowHandles());
		chromeDriver.switchTo().window(tabs.get(2));
		Thread.sleep(500);
		chromeDriver.get("https://new.land.naver.com/rooms");
		
		
		
		
		
		//chromeDriver.findElement(By.xpath("//*[@id=\"log.login\"]")).click();
		
		
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
		
			
//			for ( String line : Arrays.asList(chromeDriver.getPageSource().split("\n")) ) {
//				System.out.println(line);
//			}
			
						
		/* chromeDriver 종료 */
		//chromeDriver.quit();
		
		//List<WebElement> imgElement = chromeDriver.findElements(By.cssSelector("img"));
		
		/* */
		
		
		
		
	}
}

