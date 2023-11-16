package KISHORE.AUTOMATION.helper;

import KISHORE.AUTOMATION.utility.CONSTANT;
import com.google.common.collect.ImmutableList;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.devtools.v94.emulation.Emulation;
import org.openqa.selenium.devtools.v94.performance.Performance;
import org.openqa.selenium.devtools.v94.performance.model.Metric;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.openqa.selenium.devtools.v94.network.Network.loadingFailed;

public class ChromeDevTools extends CommonHelper{
//    static Logger log = Logger.getLogger(ChromeDevTools.class.getName());
    public static void emulateGeoLocation(Number latitude, Number longitude,Number accuracy){
        CONSTANT.DEVTOOLS.createSession();
        CONSTANT.DEVTOOLS.send(Emulation.setGeolocationOverride(Optional.of(latitude),
                Optional.of(longitude),
                Optional.of(accuracy)));

    }
    public static void simulateDeviceMode(){
        CONSTANT.DEVTOOLS.createSession();
        // iPhone 11 Pro dimensions
        CONSTANT.DEVTOOLS.send(Emulation.setDeviceMetricsOverride(375,
                812,
                50,
                true,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
    }
    public static void consoleLog(){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logEntry =  logEntries.getAll();
        for(LogEntry e : logEntry){
            System.out.println(e.getMessage());
        }
        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs= entry.getAll();
    }
    public static void blockNetworkAccess(){
        CONSTANT.DEVTOOLS.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        CONSTANT.DEVTOOLS.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
    }
    public static void basicAuth(String urlContains){
        Predicate<URI> uriPredicate = uri ->  uri.getHost().contains(urlContains);
        ((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("username", "[pass]"));
        driver.get("");
    }
    public static void networkLog(){
        CONSTANT.DEVTOOLS.createSession();
        CONSTANT.DEVTOOLS.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        CONSTANT.DEVTOOLS.addListener(Network.requestWillBeSent(), request ->
        {
            Request req = request.getRequest();
            System.out.println(req.getUrl());
        });
        //Event will get fired-
        CONSTANT.DEVTOOLS.addListener(Network.responseReceived(), response ->
        {
            Response res = response.getResponse();
            System.out.println(res.getUrl());
            System.out.println(res.getStatus());
            if(res.getStatus().toString().startsWith("4"))
            {
                System.out.println(res.getUrl()+"is failing with status code"+res.getStatus());
            }
        });
    }
    public static void offlineThrottle(){
        CONSTANT.DEVTOOLS.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        CONSTANT.DEVTOOLS.send(
                Network.emulateNetworkConditions(true, 2000, 200000, 100000, Optional.of(ConnectionType.ETHERNET)));
        CONSTANT.DEVTOOLS.addListener(loadingFailed(), loadingFailed ->
        {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
            // Assert.assertEquals(loadingFailed.getErrorText(), "net::ERR_INTERNET_DISCONNECTED");
        });
    }
    public static void performanceMetrics() {
        CONSTANT.DEVTOOLS.createSession();
        CONSTANT.DEVTOOLS.send(Performance.enable(Optional.empty()));
        List<Metric> metricList = CONSTANT.DEVTOOLS.send(Performance.getMetrics());
        for(Metric m : metricList) {
            System.out.println(m.getName() + " = " + m.getValue());
        }
    }
}
