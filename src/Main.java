import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
//		List<String> cookies = getJsonString("http://www.baidu.com","",50000);
//		if(null != cookies){
//			HashMap<String,String> map = getSessionIDString(cookies);
//		    Collection<?> keys = map.keySet();
//	        for (Object key : keys) {
//				System.out.println(key+": "+map.get(key));	
//	        }
//		}
		ReentrantLock lock = new ReentrantLock();
		int[][] matrix = {
		                  {3, 0, 1, 4, 2},
		                  {5, 6, 3, 2, 1},
		                  {1, 2, 0, 1, 5},
		                  {4, 1, 0, 1, 7},
		                  {1, 0, 3, 0, 5}
		};
		NumMatrix numMatrix = new NumMatrix(matrix);
		for(int i=0; i<numMatrix.matrixSum.length; i++){
			System.out.println("");
			for(int j=0; j<numMatrix.matrixSum[0].length; j++){
				System.out.print(numMatrix.matrixSum[i][j]+"  ,");
			}
		}
		
	}
	
	public final static List<String> getJsonString(String urlStr, String postStr,int timeOut) {
        HttpURLConnection conn = null;
        try{
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(timeOut);
            conn.setReadTimeout(timeOut);
            conn.setRequestMethod("GET");
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //获取cookie后，请求时传回给服务器
            //conn.setRequestProperty("Cookie", "BAIDUID=138A038ED1040CD68C8A367F1C1556BF:FG=1");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();

            //数据发送到服务器
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(postStr);
            out.flush();
            out.close();

            //从服务器获取数据
            InputStream is = conn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuffer sb = new StringBuffer();
            String line;
            while((line = rd.readLine())!=null){
                sb.append(line);
            }
            List<String> cookies = conn.getHeaderFields().get("Set-Cookie");
            return cookies;
        }catch(SocketTimeoutException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
	
    public static HashMap<String, String> getSessionIDString(List<String> list) {
        HashMap<String, String> cookieContainer = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String cookie = list.get(i);
            String[] cookieValues = cookie.split(";");
            for (int j = 0; j < cookieValues.length; j++) {
            	int sepIdx = 0;
            	while(sepIdx<cookieValues[j].length()){
            		if(cookieValues[j].charAt(sepIdx) == '='){
            			break;
            		}
            		sepIdx++;
            	}
            	String key = cookieValues[j].substring(0, sepIdx);
            	String value = cookieValues[j].substring(sepIdx+1, cookieValues[j].length());
                cookieContainer.put(key, value);
            }
        }
        return cookieContainer;
    }
}
