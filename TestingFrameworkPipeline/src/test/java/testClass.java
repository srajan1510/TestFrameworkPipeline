import Listeners.TestNGListeners;
import Listeners.WebdriverEventListeners;
import WebLibraries.BrowserClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.*;

import static WebLibraries.BrowserClass.enablejQuery;

@Listeners(TestNGListeners.class)
public class testClass {

    HashMap<String, String> map = new HashMap<>();
    WebDriver driver = null;
    EventFiringWebDriver eventFiringWebDriver = null;
    JavascriptExecutor js;
    int a[] = {5, 2, 7, 1, 6, 0, 8, 3};

    @Test
    public void testName() {
        driver = BrowserClass.initchromeDriver();
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        WebdriverEventListeners eventListeners = new WebdriverEventListeners();
        eventFiringWebDriver.register(eventListeners);
        js = (JavascriptExecutor) eventFiringWebDriver;
        eventFiringWebDriver.get("http://www.amazon.in");
        String webPageTitle = eventFiringWebDriver.getTitle();
        /*Assert.assertEquals(webPageTitle.length()>0,true);
        System.out.println(webPageTitle);
        Assert.assertEquals("Google",webPageTitle);
        System.out.println("PASSED");
        for (int i=webPageTitle.length()-1;i>=0;i--){
            System.out.println(webPageTitle.charAt(i));
        }
        map.put("WebTitle",webPageTitle);
        //System.out.println(driver.manage().logs().get(LogType.PERFORMANCE).getAll().get(0));
        Assert.assertEquals(palindronicString(),true);
        Assert.assertEquals(webPageTitle.compareTo(reverseWebPageTitle())>0,false);*/
    }

    public boolean palindronicString() {

        String palinStr = map.get("WebTitle").substring(0, map.get("WebTitle").length() - 2).toLowerCase();
        System.out.println(palinStr);


        int lenPaliStr = palinStr.length();
        for (int i = 0; i < lenPaliStr / 2; i++) {
            if (palinStr.charAt(i) != palinStr.charAt(lenPaliStr - 1 - i)) {
                System.out.println(palinStr + " is not palindronic");
                return false;
            }

        }
        return true;
    }

    public String reverseWebPageTitle() {

        String title = map.get("WebTitle");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = title.length() - 1; i >= 0; i--) {
            stringBuilder.append(title.charAt(i));
        }
        String revStr = stringBuilder.toString();
        System.out.println(revStr);

        return revStr;

    }

    @Test
    public void inputDataGoogleSearch() throws Exception {

        String readyState = js.executeScript("return document.readyState").toString();
        System.out.println(readyState);
        enablejQuery();
        List<WebElement> inputelem = (List<WebElement>) js.executeScript("return $('#twotabsearchtextbox')");
        String id = inputelem.get(0).getAttribute("id");
        System.out.println(id);

    }

    @Parameters({"k"})
    @Test
    public void heapSortFindKSmallestElementArray(String k) {

        int x = Integer.valueOf(k);
        int maxHeap = 0;
        maxHeap = findMinHeapElement(x);
        int temp = 0;

        for (int i = x; i < a.length; i++) {

            if (a[i] > maxHeap) {

                temp = a[i];
                a[i] = a[0];
                a[0] = temp;

            }
            maxHeap = findMinHeapElement(x);
        }

        System.out.println(a);

        /*for (int i = x; i < a.length; i++) {

         *//* for (int j = 0; j < x; j++) {
                if (a[j] > a[i])
                    temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;

            }
            System.out.println(a);*//*
        }*/


    }

    public int findMinHeapElement(int size) {
        int temp = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                if (a[j] > a[i]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
                if (a[j] < a[i]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
            return a[0];
        }
        return temp;
    }

    @Parameters({"sample"})
    @Test
    public void removeDuplicateCharFromString(String sample) {

        //sample="Call taxi; xpected output = "Cal taxi";

        String[] chrArray=sample.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String str:chrArray){

            for (Character chr:removeDuplicateFromString(str)){
                sb.append(chr);
                //sb.append(' ');
            }

            sb.append(' ');
        }

        System.out.println(sb.toString().trim());

    }

    public ArrayList<Character> removeDuplicateFromString(String a){

        ArrayList<Character> characterArrayList = new ArrayList<>();

        for (char chr:a.toCharArray()){
            if (characterArrayList.indexOf(chr)==-1){
                characterArrayList.add(chr);
            }
        }

        return characterArrayList;

    }



}



