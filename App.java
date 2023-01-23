/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jsoupprojects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import java.io.IOException;

public class App {

    public Document cookieSignInExample() throws IOException {
        Connection session = Jsoup.newSession();
        Connection.Response initial = session.newRequest().url("https://login.metafilter.com")
            .timeout(15000)
            .userAgent("Mozilla")
            .method(Connection.Method.GET)
            .execute();
        
        //You may need to use your Browser Developer Tools to inspect the HTML of your specific site to find 
        //the login URL. This can be found in the form html. Enter the form name and form value in the data(formName,formValue) method.
        Connection.Response login = session.newRequest().url("https://login.metafilter.com/logging-in.mefi")
            .timeout(15000)
            .userAgent("Mozilla")
            .data("user_name", "yourUserNameHere")
            .data("user_pass", "yourPasswordHere")
            .method(Connection.Method.POST)
            .execute();

        Document doc = session.newRequest().url("https://www.metafilter.com/contribute/activity/")
            .timeout(15000)
            .userAgent("Mozilla")
            .get();

        return doc;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(new App().getGreeting());
        App exampleCookieSignIn = new App();
        System.out.println(exampleCookieSignIn.cookieSignInExample());
    }
}
