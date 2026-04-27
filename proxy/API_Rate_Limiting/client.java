package LLD_Khauf_coder.proxy.API_Rate_Limiting;

import LLD_Khauf_coder.proxy.API_Rate_Limiting.proxy.ApiProxy;

public class client {
    public static void main(String[] args) {


        Thread t1=new Thread(()->{
            ApiService apiProxy = new ApiProxy();
            String userId = "user123";
            for (int i = 0; i < 7; i++) {
                String response = apiProxy.fetchData(userId);
                System.out.println("Response for iteration: " + i + " " + response);

            }
        });

        Thread t2=new Thread(()->{
            ApiService apiProxy = new ApiProxy();
            String userId = "user456";
            for (int i = 0; i < 3; i++) {
                String response = apiProxy.fetchData(userId);
                System.out.println("Response for iteration: " + i + " " + response);

            }
        });

        t1.start();
        t2.start();

    }
}
